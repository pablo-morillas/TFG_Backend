package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import entities.Pregunta;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="tests")
public class Test implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="nombre")
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "testid", referencedColumnName = "id")
    @JsonIgnore
    private Set<Pregunta> preguntas;


    @ManyToOne
    @JoinColumn(name = "emailusuario" ,insertable = false, updatable = false)
    Usuario admin;


    public Test(){
    }

    public Test(String nombre, Set<Pregunta> preguntas) {
        this.nombre = nombre;
        this.preguntas = preguntas;
    }



    @Override
    public String toString() {
        return "Test{" +
                ", nombre='" + nombre + '\'' +
                ", preguntas='" + preguntas + '\'' +
                '}';
    }

    public Set<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<Pregunta> preguntas){
        this.preguntas = preguntas;
    }

    public void addPregunta(Pregunta pregunta) {
        this.preguntas.add(pregunta);
    }

    public int getId() {
        return id;
    }
}