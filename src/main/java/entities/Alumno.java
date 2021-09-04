package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name= "alumnos")
public class Alumno extends Usuario {

    @Column(name="nivel", columnDefinition = "numeric default 0")
    private int nivel;

    @Column(name="puntos", columnDefinition = "numeric default 0")
    private int puntos;

    @ManyToOne
    @JoinColumn(name = "emailProfesor" ,insertable = false, updatable = false)
    Profesor Profesor;


    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

}
