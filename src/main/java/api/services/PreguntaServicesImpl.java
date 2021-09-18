package api.services;

import api.dao.PreguntaDAO;
import entities.Pregunta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("preguntaservices")
@Transactional
public class PreguntaServicesImpl implements PreguntaServices {

    @Autowired
    @Qualifier("preguntarepository")
    private PreguntaDAO preguntaDAO;

    @Override
    public boolean altaPregunta(Pregunta pregunta) {
        return preguntaDAO.save(pregunta) != null;
    }


    @Override
    public boolean deletePregunta(Pregunta pregunta) {
        preguntaDAO.delete(pregunta);
        return !preguntaDAO.findById(pregunta.getId()).isPresent();
    }


    @Override
    public List<Pregunta> findAllPregunta() {
        return preguntaDAO.findAll();
    }

    @Override
    public Pregunta findById(int id) {
        Pregunta preguntafind = null;
        Optional<Pregunta> pregunta = preguntaDAO.findById(id);
        if (pregunta.isPresent()) preguntafind = pregunta.get();
        return  preguntafind;
    }

}
