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

    @Column(name="respuestacorrecta")
    private String respuestaCorrecta;

    @Column(name="respuestaincorrecta1")
    private String respuestaIncorrecta1;

    @Column(name="respuestaincorrecta2")
    private String respuestaIncorrecta2;

    @Column(name="respuestaincorrecta3")
    private String respuestaIncorrecta3;

    @ManyToOne
    @JoinColumn(name = "testid" ,insertable = false, updatable = false)
    Test testId;


    public Pregunta(){
    }

    public Pregunta(String respuestaCorrecta, String respuestaIncorrecta1, String respuestaIncorrecta2, String respuestaIncorrecta3) {
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuestaIncorrecta1 = respuestaIncorrecta1;
        this.respuestaIncorrecta2 = respuestaIncorrecta2;
        this.respuestaIncorrecta3 = respuestaIncorrecta3;
    }


    @Override
    public String toString() {
        return "Pregunta{" +
                ", respuestacorrecta='" + respuestaCorrecta + '\'' +
                ", respuestaincorrecta1='" + respuestaIncorrecta1 + '\'' +
                ", respuestaincorrecta2='" + respuestaIncorrecta2 + '\'' +
                ", respuestaincorrecta3='" + respuestaIncorrecta3 + '\'' +
                '}';
    }


    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getRespuestaIncorrecta1() {
        return respuestaIncorrecta1;
    }

    public void setRespuestaIncorrecta1(String respuestaIncorrecta1) {
        this.respuestaIncorrecta1 = respuestaIncorrecta1;
    }

    public String getRespuestaIncorrecta2() {
        return respuestaIncorrecta2;
    }

    public void setRespuestaIncorrecta2(String respuestaIncorrecta2) {
        this.respuestaIncorrecta2 = respuestaIncorrecta2;
    }

    public String getRespuestaIncorrecta3() {
        return respuestaIncorrecta3;
    }

    public void setRespuestaIncorrecta3(String respuestaIncorrecta3) {
        this.respuestaIncorrecta3 = respuestaIncorrecta3;
    }
}