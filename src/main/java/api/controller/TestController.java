package api.controller;

import api.dto.*;
import api.services.TestServices;
import entities.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import static com.tfg.Project.GestorUsuarios.*;

@RestController
@RequestMapping(value="/api/tests")
public class TestController {

    @Autowired
    @Qualifier("testsservices")
    private TestServices testServices;

    public static final String HEADER_AUTHORIZATION_KEY = "Authorization";

    // - Get todos los tests
    @GetMapping(value = "")
    public ResponseEntity<List<Test>> getTests(@RequestHeader(name = "Authorization", required = false) String token) {
        try {
            decodeJWT(token);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        List<Test> tests = testServices.findAllTest();
        if (tests == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(tests, HttpStatus.OK);
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
    public ResponseEntity<Void> deleteTest(@PathVariable(name = "id") int id, @RequestHeader(name = "Authorization", required = false) String token) {
        try {
            decodeJWT(token);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

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