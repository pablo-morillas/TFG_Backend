package api.services;

import api.dao.ProfesorDAO;
import entities.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Optional;

import static com.tfg.Project.GestorUsuarios.validatePassword;

@Service("profesorservices")
@Transactional
public class ProfesorServicesImpl implements ProfesorServices {

    @Autowired
    @Qualifier("profesorrepository")
    private ProfesorDAO profesorDAO;

    @Override
    public boolean altaProfesor(Profesor profesor) {
        return profesorDAO.save(profesor) != null;
    }

    @Override
    public boolean deleteProfesorByEmail(String email) {
        boolean result = false;
        Profesor profesor = findByEmail(email);
        if(profesor != null) {
            result = deleteProfesor(profesor);
        }
        return result;
    }

    @Override
    public boolean deleteProfesor(Profesor profesor) {
        profesorDAO.delete(profesor);
        return !profesorDAO.findById(profesor.getEmail()).isPresent();
    }

    @Override
    public void updateProfesor(Profesor profesor) {
        profesorDAO.save(profesor);
    }

    @Override
    public List<Profesor> findAllProfesor() {
        return profesorDAO.findAll();
    }

    @Override
    public Profesor findByUsername(String username) {
        return profesorDAO.findByUsername(username);
    }

    @Override
    public Profesor findByEmail(String email) {
        Profesor profesor = null;
        Optional<Profesor> profe = profesorDAO.findById(email);
        if (profe.isPresent()) profesor = profe.get();
        return  profesor;
    }

    @Override
    public boolean login(String email, String password) {
        try{
            boolean result = false;
            Profesor profesor = findByEmail(email);
            if (profesor != null) result = validatePassword(password,profesor.getPassword());
            return result;
        }catch (InvalidKeySpecException | NoSuchAlgorithmException e){
            return false;
        }
    }
}
