package api.services;


import entities.Informe;
import entities.InformeID;

import java.util.List;

public interface InformeServices {
    boolean altaInforme(Informe informe);
    boolean deleteInforme(Informe informe);
    List<Informe> findAllInformes();
    Informe findById(InformeID id);
}
