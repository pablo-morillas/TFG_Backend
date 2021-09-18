package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tests")
public class Test implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="nombre")
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="test")
    @JsonIgnore
    private List<Pregunta> preguntas;


    @ManyToOne
    private Clase clase;


    public Test(){
    }

    public Test(String nombre) {
        this.nombre = nombre;
    }



    @Override
    public String toString() {
        return "Test{" +
                ", nombre='" + nombre + '\'' +
                ", preguntas='" + preguntas + '\'' +
                '}';
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas){
        this.preguntas = preguntas;
    }

    public void addPregunta(Pregunta pregunta) {
        this.preguntas.add(pregunta);
    }

    public int getId() {
        return id;
    }

    public Clase getClase(){
        return clase;
    }

    public void setClase(Clase clase){
        this.clase = clase;
    }

}