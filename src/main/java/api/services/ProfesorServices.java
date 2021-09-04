package api.services;

import entities.Profesor;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public interface ProfesorServices {
    boolean altaProfesor(Profesor usuario);
    boolean deleteProfesorByEmail(String username);
    boolean deleteProfesor(Profesor usuario);
    void updateProfesor(Profesor usuario);
    List<Profesor> findAllProfesor();
    Profesor findByUsername(String username);
    Profesor findByEmail(String email);
    boolean login(String email, String password) throws InvalidKeySpecException, NoSuchAlgorithmException;
}
