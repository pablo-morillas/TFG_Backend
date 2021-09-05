package api.dto;

import entities.Clase;
import entities.Test;
import entities.Usuario;

import java.util.Set;

public class ClaseDTO {

    private Usuario profesor;

    private Set<Test> tests;

    public ClaseDTO() {
    }

    public ClaseDTO(Usuario profesor, Set<Test> tests) {
        this.profesor = profesor;
        this.tests = tests;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

    public Usuario getProfesor() {
        return profesor;
    }

    public void setProfesor(Usuario profesor) {
        this.profesor = profesor;
    }

}

