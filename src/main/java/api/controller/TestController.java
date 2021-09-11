package api.controller;

import api.dto.*;
import api.services.ClaseServices;
import api.services.TestServices;
import api.services.UsuarioServices;
import entities.Clase;
import entities.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@RequestMapping(value="/api/{email}/{claseid}/tests")
public class TestController {

    @Autowired
    private UsuarioServices usuarioServices;

    @Autowired
    private ClaseServices claseServices;

    @Autowired
    private TestServices testServices;


    // - Get todos los tests
    @GetMapping(value = "")
    public ResponseEntity<Set<Test>> getTestsClase(@PathVariable(name="claseid") int claseid) {

        Clase clase = claseServices.findById(claseid);

        if (clase == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(clase.getTests(), HttpStatus.OK);
        }
    }

    //CREATE Test
    @PostMapping(value = "")
    public ResponseEntity<String> addTest(@RequestBody TestDTO testDTO) {

        Test test = new Test();

        test.setPreguntas(testDTO.getPreguntas());
        testServices.altaTest(test);

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