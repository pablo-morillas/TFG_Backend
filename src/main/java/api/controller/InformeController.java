package api.controller;

import api.dto.InformeDTO;
import api.dto.InformeIDDTO;
import api.services.*;
import entities.Informe;
import entities.InformeID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/informes")
public class InformeController {

    @Autowired
    private UsuarioServices usuarioServices;

    @Autowired
    private InformeServices informeServices;


    // - Get todos los informes
    @GetMapping(value = "")
    public ResponseEntity<List<Informe>> getInformes() {

        List<Informe> informes = informeServices.findAllInformes();
        if (informes == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(informes, HttpStatus.OK);
        }
    }

    //CREATE Informe
    @PostMapping(value = "")
    public ResponseEntity<String> addInforme(@RequestBody InformeDTO informeDTO) {

        if (usuarioServices.findByEmail(informeDTO.getId().getEstudiantId()) == null || usuarioServices.findByEmail(informeDTO.getId().getProfessorId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Informe informe = new Informe();
            informe.setId(new InformeID(informeDTO.getId().getEstudiantId(), informeDTO.getId().getProfessorId()));
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }


    //DELETE Informe
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable(name = "id") InformeID id) {


        Informe informe;
        if (informeServices.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            boolean delete;
            informe = informeServices.findById(id);
            delete = informeServices.deleteInforme(informe);
            if (delete) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}