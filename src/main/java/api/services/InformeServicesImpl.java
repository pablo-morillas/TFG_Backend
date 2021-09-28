package api.services;

import api.dao.InformeDAO;
import entities.Informe;
import entities.InformeID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("informeservices")
@Transactional
public class InformeServicesImpl implements InformeServices {

    @Autowired
    @Qualifier("informerepository")
    private InformeDAO informeDAO;




    @Override
    public boolean altaInforme(Informe informe) {
        return informeDAO.save(informe) != null;
    }

    @Override
    public boolean deleteInforme(Informe informe) {
        informeDAO.delete(informe);
        return !informeDAO.findById(informe.getId()).isPresent();
    }

    @Override
    public List<Informe> findAllInformes() {
        return informeDAO.findAll();
    }

    @Override
    public Informe findById(InformeID id) {
        Informe informefind = null;
        Optional<Informe> informe = informeDAO.findById(id);
        if (informe.isPresent()) informefind = informe.get();
        return  informefind;
    }

}
