package api.services;

import entities.Alumno;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public interface AlumnoServices {
    boolean altaAlumno(Alumno usuario);
    boolean deleteAlumnoByEmail(String username);
    boolean deleteAlumno(Alumno usuario);
    void updateAlumno(Alumno usuario);
    List<Alumno> findAllAlumno();
    Alumno findByUsername(String username);
    Alumno findByEmail(String email);
    boolean login(String email, String password) throws InvalidKeySpecException, NoSuchAlgorithmException;
}
