package api.services;

import entities.Clase;

import java.util.List;

public interface ClaseServices {
    boolean altaClase(Clase clase);
    boolean deleteClase(Clase clase);
    List<Clase> findAllClase();
    Clase findById(int id);
}
