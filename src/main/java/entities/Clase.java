package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="clases")
public class Clase implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;


    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    private Usuario profesor;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="clase")
    @JsonIgnore
    private List<Test> tests;


    @JsonIgnore
    @ManyToMany()
    private Set<Usuario> participantes = new HashSet<>();


    public Clase(){
    }

    public Clase(Usuario profesor, String nombre) {
        this.profesor = profesor;
        this.nombre = nombre;
    }


    public Usuario getProfesor() {
        return profesor;
    }

    public void setProfesor(Usuario profesor) {
        this.profesor = profesor;
    }

    public Set<Usuario> getAlumnos() {
        return participantes;
    }

    public void addAlumno(Usuario alumno){
        this.participantes.add(alumno);
    }

    public List<Test> getTests() {
        return tests;
    }

    public void addTest(Test test){
        this.tests.add(test);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Clase{" +
                ", nombre='" + nombre + '\'' +
                ", profesor='" + profesor + '\'' +
                ", tests='" + tests + '\'' +
                ", alumnos='" + participantes + '\'' +
                '}';
    }
}