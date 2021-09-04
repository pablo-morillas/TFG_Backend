package api.controller;

import api.dto.*;
import api.services.AlumnoServices;
import com.ja.security.PasswordHash;
import entities.Alumno;
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
@RequestMapping(value="/api/alumnos")
public class AlumnoController {

    @Autowired
    @Qualifier("alumnoservices")
    private AlumnoServices alumnoServices;

    public static final String HEADER_AUTHORIZATION_KEY = "Authorization";

    //UPDATE CONTRASEÑA
    @PutMapping(value= "/{email}/forgot")
    public ResponseEntity<Void> updatePasswordAlumno(@RequestBody UsuarioUpdatePasswordDTO usuarioUpdatePasswordDTO, @PathVariable(name="email") String email,
                                                      @RequestHeader(name="Authorization",required = false) String token) throws InvalidKeySpecException, NoSuchAlgorithmException {

        try{
            if(!decodeJWT(token).equals(email)){
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        Alumno alumno = alumnoServices.findByEmail(email);
        if (alumno == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(!alumnoServices.login(email, usuarioUpdatePasswordDTO.getOldPassword())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        String hashedPassword = new PasswordHash().createHash(usuarioUpdatePasswordDTO.getNewPassword());
        alumno.setPassword(hashedPassword);

        alumnoServices.updateAlumno(alumno);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    //UPDATE CAMPOS
    @PutMapping(value= "/{email}")
    public ResponseEntity<Void> updateCamposAlumno(@RequestBody UsuarioUpdateCamposDTO usuarioUpdateCamposDTO, @PathVariable(name="email") String email,
                                                    @RequestHeader(name="Authorization",required = false) String token) {

        try{
            if(!decodeJWT(token).equals(email)){
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        Alumno alumno = alumnoServices.findByEmail(email);
        if (alumno == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        alumno.setUsername(usuarioUpdateCamposDTO.getUsername());
        alumno.setNombre(usuarioUpdateCamposDTO.getNombre());

        alumnoServices.updateAlumno(alumno);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    // - Get todos los Alumnos
    @GetMapping(value = "")
    public ResponseEntity<List<Alumno>> getAlumnos(@RequestHeader(name = "Authorization", required = false) String token) {
        try {
            decodeJWT(token);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        List<Alumno> alumnos = alumnoServices.findAllAlumno();
        if (alumnos == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(alumnos, HttpStatus.OK);
        }
    }

    //READ USER
    @GetMapping(value = "/{email}")
    public ResponseEntity<UsuarioAuxiliarDTO> getAlumnoByEmail(@PathVariable(name = "email") String email) {
        Usuario usuario = alumnoServices.findByEmail(email);
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

        Alumno alumn = new Alumno();

        alumn.setUsername(userDTO.getUsername());
        alumn.setPassword(hashedPassword(userDTO.getPassword()));
        alumn.setEmail(userDTO.getEmail());
        alumn.setNombre(userDTO.getNombre());

        Alumno alumnoExistente = alumnoServices.findByEmail(alumn.getEmail());
        if (alumnoExistente == null) {
            if (alumnoServices.findByUsername(alumn.getUsername()) != null) {
                return new ResponseEntity<>("username", HttpStatus.BAD_REQUEST);
            }
            alumnoServices.altaAlumno(alumn);
            String token = createToken(alumn.getEmail());
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HEADER_AUTHORIZATION_KEY, token);
            return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("email", HttpStatus.BAD_REQUEST);
    }

    //LOGIN
    @PostMapping(value = "/login")
    public ResponseEntity<Void> loginRequest(@RequestBody LoginBody login) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (alumnoServices.login(login.getEmail(), login.getPassword())) { // Llamada a gestorUsuarios
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
        if (alumnoServices.findByEmail(email) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            boolean delete;
            delete = alumnoServices.deleteAlumnoByEmail(email);
            if (delete) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}