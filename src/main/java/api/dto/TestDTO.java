package api.dto;

import entities.Pregunta;

import java.util.Set;

public class TestDTO {

    private String nombre;

    private Set<Pregunta> preguntas;

    public TestDTO() {
    }

    public TestDTO(String nombre, Set<Pregunta> preguntas) {
        this.nombre = nombre;
        this.preguntas = preguntas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
}

