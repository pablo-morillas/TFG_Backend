package api.services;

import api.dao.ClaseDAO;
import entities.Clase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("claseservices")
@Transactional
public class ClaseServicesImpl implements ClaseServices {

    @Autowired
    @Qualifier("claserepository")
    private ClaseDAO claseDAO;

    @Override
    public boolean altaClase(Clase clase) {
        return claseDAO.save(clase) != null;
    }


    @Override
    public boolean deleteClase(Clase clase) {
        claseDAO.delete(clase);
        return !claseDAO.findById(clase.getId()).isPresent();
    }


    @Override
    public List<Clase> findAllClase() {
        return claseDAO.findAll();
    }

    @Override
    public Clase findById(int id) {
        Clase clasefind = null;
        Optional<Clase> clase = claseDAO.findById(id);
        if (clase.isPresent()) clasefind = clase.get();
        return  clasefind;
    }

}
