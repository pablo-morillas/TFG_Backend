package api.controller;

import api.dto.AlumnoAssistenteDTO;
import api.dto.ClaseDTO;
import api.services.ClaseServices;
import api.services.UsuarioServices;
import entities.Clase;
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


    //Añadir participante a Clase
    @PutMapping(value = "")
    public ResponseEntity<Void> addAssistent(@RequestBody AlumnoAssistenteDTO alumnoAssistenteDTO) {

        if(usuarioServices.findByEmail(alumnoAssistenteDTO.getAlumnoAssistenteEmail()) == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(claseServices.findById(alumnoAssistenteDTO.getClaseId()) == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Clase clase = claseServices.findById(alumnoAssistenteDTO.getClaseId());
        Usuario alumno = usuarioServices.findByEmail(alumnoAssistenteDTO.getAlumnoAssistenteEmail());

        try{
            clase.addAlumno(alumno);
            claseServices.altaClase(clase);
        }
        catch(PersistenceException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // - Get todos los alumnos de una clase
    @GetMapping(value = "/{claseid}/alumnos")
    public ResponseEntity<List<Usuario>> getClasesParticipantes(@PathVariable(name="claseid") int id) {

        Clase clase = claseServices.findById(id);

        if (clase == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(clase.getParticipantes(), HttpStatus.OK);
        }
    }

    // DELETE from alumnos

    @DeleteMapping(value = "/{claseid}/{alumnoemail}")
    public ResponseEntity<Void> deleteAlumnoClase(@PathVariable(name="claseid") int claseid, @PathVariable(name="alumnoemail") String alumnoemail) {

        Clase clase = claseServices.findById(claseid);
        Usuario user  = usuarioServices.findByEmail(alumnoemail);

        if (clase == null  || user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else if (!clase.getParticipantes().contains(user)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else{
            clase.removeAlumno(user);
            claseServices.altaClase(clase);
        }
        return new ResponseEntity<>(HttpStatus.OK);
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