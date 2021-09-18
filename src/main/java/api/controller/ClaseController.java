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

import javax.persistence.PersistenceException;
import java.util.List;
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
    public ResponseEntity<List<Clase>> getClasesUsuario(@PathVariable(name="email") String email) {

        Usuario usuario = usuarioServices.findByEmail(email);

        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(usuario.getClases(), HttpStatus.OK);
        }
    }

    // - Get todos las clases
    @GetMapping(value = "Part")
    public ResponseEntity<List<Clase>> getClasesParticipantes(@PathVariable(name="email") String email) {

        Usuario usuario = usuarioServices.findByEmail(email);

        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(usuario.getClasesPertany(), HttpStatus.OK);
        }
    }



    //CREATE Clase
    @PostMapping(value = "")
    public ResponseEntity<Clase> addClase(@RequestBody ClaseDTO claseDTO, @PathVariable(name="email") String email) {

        Clase clase = new Clase();

        if(usuarioServices.findByEmail(email) == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        clase.setProfesor(usuarioServices.findByEmail(email));
        clase.setNombre(claseDTO.getNombre());

        try {
            claseServices.altaClase(clase);
        }
        catch(PersistenceException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(clase,HttpStatus.CREATED);
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