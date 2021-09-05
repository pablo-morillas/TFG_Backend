package api.dto;

import entities.Clase;
import entities.Test;
import entities.Usuario;

import java.util.Set;

public class ClaseDTO {


    private String nombre;


    public ClaseDTO() {
    }

    public ClaseDTO(String nombre) {
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

