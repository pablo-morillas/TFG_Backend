package api.controller;

import api.dto.*;
import api.services.ProfesorServices;
import com.ja.security.PasswordHash;
import entities.Profesor;
import entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import static com.tfg.Project.GestorUsuarios.*;

@RestController
@RequestMapping(value="/api/profesores")
public class ProfesorController {

    @Autowired
    @Qualifier("profesorservices")
    private ProfesorServices profesorServices;

    public static final String HEADER_AUTHORIZATION_KEY = "Authorization";

    //UPDATE CONTRASEÑA
    @PutMapping(value= "/{email}/forgot")
    public ResponseEntity<Void> updatePasswordprofesor(@RequestBody UsuarioUpdatePasswordDTO usuarioUpdatePasswordDTO, @PathVariable(name="email") String email,
                                                      @RequestHeader(name="Authorization",required = false) String token) throws InvalidKeySpecException, NoSuchAlgorithmException {

        try{
            if(!decodeJWT(token).equals(email)){
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        Profesor profesor = profesorServices.findByEmail(email);
        if (profesor == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(!profesorServices.login(email, usuarioUpdatePasswordDTO.getOldPassword())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        String hashedPassword = new PasswordHash().createHash(usuarioUpdatePasswordDTO.getNewPassword());
        profesor.setPassword(hashedPassword);

        profesorServices.updateProfesor(profesor);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    //UPDATE CAMPOS
    @PutMapping(value= "/{email}")
    public ResponseEntity<Void> updateCamposProfesor(@RequestBody UsuarioUpdateCamposDTO usuarioUpdateCamposDTO, @PathVariable(name="email") String email,
                                                    @RequestHeader(name="Authorization",required = false) String token) {

        try{
            if(!decodeJWT(token).equals(email)){
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        Profesor profesor = profesorServices.findByEmail(email);
        if (profesor == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        profesor.setUsername(usuarioUpdateCamposDTO.getUsername());
        profesor.setNombre(usuarioUpdateCamposDTO.getNombre());

        profesorServices.updateProfesor(profesor);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    // - Get todos los Alumnos
    @GetMapping(value = "")
    public ResponseEntity<List<Profesor>> getProfesores(@RequestHeader(name = "Authorization", required = false) String token) {
        try {
            decodeJWT(token);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        List<Profesor> alumnos = profesorServices.findAllProfesor();
        if (alumnos == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(alumnos, HttpStatus.OK);
        }
    }

    //READ USER
    @GetMapping(value = "/{email}")
    public ResponseEntity<UsuarioAuxiliarDTO> getAlumnoByEmail(@PathVariable(name = "email") String email) {
        Usuario usuario = profesorServices.findByEmail(email);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            UsuarioAuxiliarDTO usuarioAmigo = new UsuarioAuxiliarDTO(usuario);

            return new ResponseEntity<>(usuarioAmigo, HttpStatus.OK);
        }
    }

    //CREATE USER
    @PostMapping(value = "")
    public ResponseEntity<String> addAlumno(@RequestBody AlumnoDTO userDTO) throws InvalidKeySpecException, NoSuchAlgorithmException {

        Profesor profe = new Profesor();

        profe.setUsername(userDTO.getUsername());
        profe.setPassword(hashedPassword(userDTO.getPassword()));
        profe.setEmail(userDTO.getEmail());
        profe.setNombre(userDTO.getNombre());

        Profesor profesorExistente = profesorServices.findByEmail(profe.getEmail());
        if (profesorExistente == null) {
            if (profesorServices.findByUsername(profe.getUsername()) != null) {
                return new ResponseEntity<>("username", HttpStatus.BAD_REQUEST);
            }
            profesorServices.altaProfesor(profe);
            String token = createToken(profe.getEmail());
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HEADER_AUTHORIZATION_KEY, token);
            return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("email", HttpStatus.BAD_REQUEST);
    }

    //LOGIN
    @PostMapping(value = "/login")
    public ResponseEntity<Void> loginRequest(@RequestBody LoginBody login) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (profesorServices.login(login.getEmail(), login.getPassword())) { // Llamada a gestorUsuarios
            String token = createToken(login.getEmail());
            HttpHeaders headers = new HttpHeaders();
            headers.add(HEADER_AUTHORIZATION_KEY, token);
            return new ResponseEntity<>(headers, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    //DELETE USER
    @DeleteMapping(value = "/{email}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable(name = "email") String email, @RequestHeader(name = "Authorization", required = false) String token) {

        try {
            if (!decodeJWT(token).equals(email)) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        if (profesorServices.findByEmail(email) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            boolean delete;
            delete = profesorServices.deleteProfesorByEmail(email);
            if (delete) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}