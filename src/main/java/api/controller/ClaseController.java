package api.controller;

import api.dto.ClaseDTO;
import api.dto.TestDTO;
import api.services.ClaseServices;
import api.services.TestServices;
import api.services.UsuarioServices;
import entities.Clase;
import entities.Test;
import entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value="/api/{email}/clases")
public class ClaseController {

    @Autowired
    private UsuarioServices usuarioServices;

    @Autowired
    private ClaseServices claseServices;



    // - Get todos las clases
    @GetMapping(value = "")
    public ResponseEntity<Set<Clase>> getClasesUsuario(@PathVariable(name="email") String email) {

        Usuario usuario = usuarioServices.findByEmail(email);

        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(usuario.getClases(), HttpStatus.OK);
        }
    }

    //CREATE Clase
    @PostMapping(value = "")
    public ResponseEntity<String> addClase(@RequestBody ClaseDTO claseDTO) {

        Clase clase = new Clase();

        clase.setProfesor(claseDTO.getProfesor());

        claseServices.altaClase(clase);

        return new ResponseEntity<>(HttpStatus.OK);

    }


    //DELETE Clase
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable(name = "id") int id) {


        Clase clase;
        if (claseServices.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            boolean delete;
            clase = claseServices.findById(id);
            delete = claseServices.deleteClase(clase);
            if (delete) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}