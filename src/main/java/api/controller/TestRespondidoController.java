package api.controller;

import api.dto.TestRespondidoDTO;
import api.services.TestRespondidoServices;
import api.services.TestServices;
import api.services.UsuarioServices;
import entities.TestRespondido;
import entities.TestRespondidoID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping(value="/api/testRespondido")
public class TestRespondidoController {

    @Autowired
    private TestRespondidoServices testRespondidoServices;

    @Autowired
    private UsuarioServices usuarioServices;

    @Autowired
    private TestServices testServices;


    // ADD UN NUEVO EXAMEN RESOLT
    @PostMapping(value = "")
    public ResponseEntity<Void> addExamenResuelto(@RequestBody TestRespondidoDTO testRespondido) throws InvalidKeySpecException, NoSuchAlgorithmException {

        System.out.println("AQUI VOY A DECIR LOS ID: " + testRespondido.getId().getAlumnoId() + " " + testRespondido.getId().getTestId() + " NOTA: " + testRespondido.getNota());
        if (usuarioServices.findByEmail(testRespondido.getId().getAlumnoId()) == null || testServices.findById(testRespondido.getId().getTestId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if(testRespondidoServices.findById(new TestRespondidoID(testRespondido.getId().getAlumnoId(), testRespondido.getId().getTestId())) != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else{
            TestRespondido test = new TestRespondido();
            test.setAlumno(usuarioServices.findByEmail(testRespondido.getId().getAlumnoId()));
            test.setTest(testServices.findById(testRespondido.getId().getTestId()));
            test.setId(new TestRespondidoID(testRespondido.getId().getAlumnoId(), testRespondido.getId().getTestId()));
            test.setNota(testRespondido.getNota());
            testRespondidoServices.altaTestRespondido(test);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

    }
}