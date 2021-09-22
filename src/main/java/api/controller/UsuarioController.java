package api.controller;

import api.dto.*;
import api.services.UsuarioServices;
import com.ja.security.PasswordHash;
import entities.Clase;
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
@RequestMapping(value="/api/usuarios")
public class UsuarioController {

    @Autowired
    @Qualifier("usuarioservices")
    private UsuarioServices usuarioServices;

    public static final String HEADER_AUTHORIZATION_KEY = "Authorization";

    //UPDATE CONTRASEÑA
    @PutMapping(value= "/{email}/forgot")
    public ResponseEntity<Void> updatePasswordUsuario(@RequestBody UsuarioUpdatePasswordDTO usuarioUpdatePasswordDTO, @PathVariable(name="email") String email,
                                                      @RequestHeader(name="Authorization",required = false) String token) throws InvalidKeySpecException, NoSuchAlgorithmException {

        try{
            if(!decodeJWT(token).equals(email)){
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        Usuario usuario = usuarioServices.findByEmail(email);
        if (usuario == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(!usuarioServices.login(email, usuarioUpdatePasswordDTO.getOldPassword())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        String hashedPassword = new PasswordHash().createHash(usuarioUpdatePasswordDTO.getNewPassword());
        usuario.setPassword(hashedPassword);

        usuarioServices.updateUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    //UPDATE PUNTOS
    @PutMapping(value= "/{email}/puntos")
    public ResponseEntity<Void> updatePuntosUsuario(@RequestBody int puntos, @PathVariable(name="email") String email,
                                                    @RequestHeader(name="Authorization",required = false) String token) {

        try{
            if(!decodeJWT(token).equals(email)){
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        Usuario  usuario = usuarioServices.findByEmail(email);
        if (usuario == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        usuario.setPuntuacion(puntos + usuario.getPuntuacion());

        usuario.setMaxpuntuacion(puntos + usuario.getMaxpuntuacion());

        usuarioServices.updateUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.OK);

    }



    //UPDATE CAMPOS
    @PutMapping(value= "/{email}")
    public ResponseEntity<Void> updateCamposUsuario(@RequestBody UsuarioUpdateCamposDTO usuarioUpdateCamposDTO, @PathVariable(name="email") String email,
                                                    @RequestHeader(name="Authorization",required = false) String token) {

        try{
            if(!decodeJWT(token).equals(email)){
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        Usuario  usuario = usuarioServices.findByEmail(email);
        if (usuario == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        usuario.setNombre(usuarioUpdateCamposDTO.getNombre());

        usuarioServices.updateUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    // - Get todos los Usuarios
    @GetMapping(value = "")
    public ResponseEntity<List<Usuario>> getUsuarios(@RequestHeader(name = "Authorization", required = false) String token) {
        try {
            decodeJWT(token);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        List<Usuario> usuarios = usuarioServices.findAllUsuario();
        if (usuarios == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }
    }

    //READ USER
    @GetMapping(value = "/{email}")
    public ResponseEntity<UsuarioAuxiliarDTO> getUsuarioByEmail(@PathVariable(name = "email") String email) {
        Usuario usuario = usuarioServices.findByEmail(email);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            UsuarioAuxiliarDTO usuarioAux = new UsuarioAuxiliarDTO(usuario);

            return new ResponseEntity<>(usuarioAux, HttpStatus.OK);
        }
    }

    //GET METRICAS DE PUNTUACION

    @GetMapping(value = "/{email}/puntuaciones")
    public ResponseEntity<UsuarioPuntosDTO> getPuntuacionesUsuario(@PathVariable(name = "email") String email) {
        Usuario usuario = usuarioServices.findByEmail(email);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            UsuarioPuntosDTO usuarioAux = new UsuarioPuntosDTO(usuario);

            return new ResponseEntity<>(usuarioAux, HttpStatus.OK);
        }
    }

    //GET CLASES PROFESOR

    @GetMapping(value = "/{email}/aulas")
    public ResponseEntity<List<Clase>> getAulasUsuario(@PathVariable(name = "email") String email) {
        Usuario usuario = usuarioServices.findByEmail(email);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            List<Clase> aulas = usuario.getClases();

            return new ResponseEntity<>(aulas, HttpStatus.OK);
        }
    }

    //GET CLASES PARTICIPANTE

    @GetMapping(value = "/{email}/aulasPertany")
    public ResponseEntity<List<Clase>> getAulasPertanyUsuario(@PathVariable(name = "email") String email) {
        Usuario usuario = usuarioServices.findByEmail(email);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            List<Clase> aulas = usuario.getClasesPertany();

            return new ResponseEntity<>(aulas, HttpStatus.OK);
        }
    }

    //CREATE USER
    @PostMapping(value = "")
    public ResponseEntity<String> addUsuario(@RequestBody UsuarioDTO userDTO) throws InvalidKeySpecException, NoSuchAlgorithmException {

        Usuario user = new Usuario();

        user.setPassword(hashedPassword(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        user.setNombre(userDTO.getNombre());
        user.setUserRole(userDTO.getUserRole());

        Usuario usuarioExistente = usuarioServices.findByEmail(user.getEmail());
        if (usuarioExistente == null) {

            usuarioServices.altaUsuario(user);
            String token = createToken(user.getEmail());
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HEADER_AUTHORIZATION_KEY, token);
            return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("email", HttpStatus.BAD_REQUEST);
    }

    //LOGIN
    @PostMapping(value = "/login")
    public ResponseEntity<Void> loginRequest(@RequestBody LoginBody login) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (usuarioServices.login(login.getEmail(), login.getPassword())) { // Llamada a gestorUsuarios
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
        if (usuarioServices.findByEmail(email) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            boolean delete;
            delete = usuarioServices.deleteUsuarioByEmail(email);
            if (delete) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}