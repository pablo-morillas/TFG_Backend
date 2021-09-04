package entities;

import entities.Respuesta;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="preguntas")
public class Pregunta implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="respuesta1")
    private Respuesta respuesta1;

    @Column(name="respuesta2")
    private Respuesta respuesta2;


    @Column(name="respuesta3")
    private Respuesta respuesta3;


    @Column(name="respuesta4")
    private Respuesta respuesta4;


    public Pregunta(){
    }

    public Pregunta(Respuesta respuesta1, Respuesta respuesta2, Respuesta respuesta3,
                    Respuesta respuesta4) {
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.respuesta4 = respuesta4;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                ", respuesta1='" + respuesta1 + '\'' +
                ", respuesta2='" + respuesta2 + '\'' +
                ", respuesta3='" + respuesta3 + '\'' +
                ", respuesta4='" + respuesta4 + '\'' +
                '}';
    }

    public Respuesta getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(Respuesta respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public Respuesta getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(Respuesta respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public Respuesta getRespuesta3() {
        return respuesta3;
    }

    public void setRespuesta3(Respuesta respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public Respuesta getRespuesta4() {
        return respuesta4;
    }

    public void setRespuesta4(Respuesta respuesta4) {
        this.respuesta4 = respuesta4;
    }
}