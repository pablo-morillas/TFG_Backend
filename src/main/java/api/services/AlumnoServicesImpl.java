package api.services;

import api.dao.AlumnoDAO;
import entities.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Optional;

import static com.tfg.Project.GestorUsuarios.validatePassword;

@Service("alumnoservices")
@Transactional
public class AlumnoServicesImpl implements AlumnoServices {

    @Autowired
    @Qualifier("alumnorepository")
    private AlumnoDAO alumnoDAO;

    @Override
    public boolean altaAlumno(Alumno alumno) {
        return alumnoDAO.save(alumno) != null;
    }

    @Override
    public boolean deleteAlumnoByEmail(String email) {
        boolean result = false;
        Alumno alumno = findByEmail(email);
        if(alumno != null) {
            result = deleteAlumno(alumno);
        }
        return result;
    }

    @Override
    public boolean deleteAlumno(Alumno alumno) {
        alumnoDAO.delete(alumno);
        return !alumnoDAO.findById(alumno.getEmail()).isPresent();
    }

    @Override
    public void updateAlumno(Alumno alumno) {
        alumnoDAO.save(alumno);
    }

    @Override
    public List<Alumno> findAllAlumno() {
        return alumnoDAO.findAll();
    }

    @Override
    public Alumno findByUsername(String username) {
        return alumnoDAO.findByUsername(username);
    }

    @Override
    public Alumno findByEmail(String email) {
        Alumno alumno = null;
        Optional<Alumno> user = alumnoDAO.findById(email);
        if (user.isPresent()) alumno = user.get();
        return  alumno;
    }

    @Override
    public boolean login(String email, String password) {
        try{
            boolean result = false;
            Alumno alumno = findByEmail(email);
            if (alumno != null) result = validatePassword(password,alumno.getPassword());
            return result;
        }catch (InvalidKeySpecException | NoSuchAlgorithmException e){
            return false;
        }
    }
}
