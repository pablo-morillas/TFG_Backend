package api.controller;

import api.dto.PreguntaDTO;
import api.services.ClaseServices;
import api.services.PreguntaServices;
import api.services.TestServices;
import api.services.UsuarioServices;
import entities.Clase;
import entities.Pregunta;
import entities.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="/api/{email}/{claseid}/{testid}/preguntas")
public class PreguntaController {

    @Autowired
    private UsuarioServices usuarioServices;

    @Autowired
    private ClaseServices claseServices;

    @Autowired
    private TestServices testServices;

    @Autowired
    private PreguntaServices preguntaServices;


    // - Get todos las preguntas
    @GetMapping(value = "")
    public ResponseEntity<List<Pregunta>> getPreguntasTest(@PathVariable(name="testid") int testid) {

        Test test = testServices.findById(testid);

        if (test == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(test.getPreguntas(), HttpStatus.OK);
        }
    }

    //CREATE Pregunta
    @PostMapping(value = "")
    public ResponseEntity<String> addPregunta(@RequestBody PreguntaDTO preguntaDTO, @PathVariable(name="testid") int testid) {

        Pregunta pregunta = new Pregunta();

        pregunta.setTextoPregunta(preguntaDTO.getText());
        pregunta.setRespuestaCorrecta(preguntaDTO.getRespuestaCorrecta());
        pregunta.setRespuestaIncorrecta1(preguntaDTO.getRespuestaIncorrecta1());
        pregunta.setRespuestaIncorrecta2(preguntaDTO.getRespuestaIncorrecta2());
        pregunta.setRespuestaIncorrecta3(preguntaDTO.getRespuestaIncorrecta3());

        pregunta.setTestId(testServices.findById(testid));

        preguntaServices.altaPregunta(pregunta);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    //DELETE Test
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable(name = "id") int id) {


        Test test;
        if (testServices.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            boolean delete;
            test = testServices.findById(id);
            delete = testServices.deleteTest(test);
            if (delete) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}