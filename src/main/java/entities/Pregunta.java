package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="preguntas")
public class Pregunta implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="text")
    private String text;

    @Column(name="respuestacorrecta")
    private String respuestaCorrecta;

    @Column(name="respuesta1")
    private String respuesta1;

    @Column(name="respuesta2")
    private String respuesta2;

    @Column(name="respuesta3")
    private String respuesta3;

    @ManyToOne
    private Test test;



    public Pregunta(){
    }

    public Pregunta(String text, String respuestaCorrecta, String respuesta1, String respuesta2, String respuesta3) {
        this.text = text;
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
    }


    @Override
    public String toString() {
        return "Pregunta{" +
                ", text='" + text + '\'' +
                ", respuestacorrecta='" + respuestaCorrecta + '\'' +
                ", respuesta1='" + respuesta1 + '\'' +
                ", respuesta2='" + respuesta2 + '\'' +
                ", respuesta3='" + respuesta3 + '\'' +
                '}';
    }


    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getRespuestaIncorrecta1() {
        return respuesta1;
    }

    public void setRespuestaIncorrecta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuestaIncorrecta2() {
        return respuesta2;
    }

    public void setRespuestaIncorrecta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getRespuestaIncorrecta3() {
        return respuesta3;
    }

    public void setRespuestaIncorrecta3(String respuesta3) {
        this.respuesta3 = respuesta3;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTextoPregunta() {
        return text;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.text = textoPregunta;
    }

    public void setTestId(Test test) {
        this.test = test;
    }
}