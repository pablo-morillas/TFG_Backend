package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import entities.Pregunta;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tests")
public class Test implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="pregunta1")
    private Pregunta pregunta1;

    @Column(name="pregunta2")
    private Pregunta pregunta2;


    @Column(name="pregunta3")
    private Pregunta pregunta3;


    @Column(name="pregunta4")
    private Pregunta pregunta4;


    @Column(name="pregunta5")
    private Pregunta pregunta5;


    @Column(name="pregunta6")
    private Pregunta pregunta6;


    @Column(name="pregunta7")
    private Pregunta pregunta7;


    @Column(name="pregunta8")
    private Pregunta pregunta8;


    @Column(name="pregunta9")
    private Pregunta pregunta9;


    @Column(name="pregunta10")
    private Pregunta pregunta10;


    public Test(){
    }

    public Test(String nombre, Pregunta pregunta1, Pregunta pregunta2, Pregunta pregunta3,
                Pregunta pregunta4, Pregunta pregunta5, Pregunta pregunta6, Pregunta pregunta7,
                Pregunta pregunta8, Pregunta pregunta9, Pregunta pregunta10) {
        this.nombre = nombre;
        this.pregunta1 = pregunta1;
        this.pregunta2 = pregunta2;
        this.pregunta3 = pregunta3;
        this.pregunta4 = pregunta4;
        this.pregunta5 = pregunta5;
        this.pregunta6 = pregunta6;
        this.pregunta7 = pregunta7;
        this.pregunta8 = pregunta8;
        this.pregunta9 = pregunta9;
        this.pregunta10 = pregunta10;
    }



    @Override
    public String toString() {
        return "Test{" +
                ", nombre='" + nombre + '\'' +
                ", pregunta1='" + pregunta1 + '\'' +
                ", pregunta2='" + pregunta2 + '\'' +
                ", pregunta3='" + pregunta3 + '\'' +
                ", pregunta4='" + pregunta4 + '\'' +
                ", pregunta5='" + pregunta5 + '\'' +
                ", pregunta6='" + pregunta6 + '\'' +
                ", pregunta7='" + pregunta7 + '\'' +
                ", pregunta8='" + pregunta8 + '\'' +
                ", pregunta9='" + pregunta9 + '\'' +
                ", pregunta10='" + pregunta10 + '\'' +
                '}';
    }

    public Pregunta getPregunta1() {
        return pregunta1;
    }

    public void setPregunta1(Pregunta pregunta1) {
        this.pregunta1 = pregunta1;
    }

    public Pregunta getPregunta2() {
        return pregunta2;
    }

    public void setPregunta2(Pregunta pregunta2) {
        this.pregunta2 = pregunta2;
    }

    public Pregunta getPregunta3() {
        return pregunta3;
    }

    public void setPregunta3(Pregunta pregunta3) {
        this.pregunta3 = pregunta3;
    }

    public Pregunta getPregunta4() {
        return pregunta4;
    }

    public void setPregunta4(Pregunta pregunta4) {
        this.pregunta4 = pregunta4;
    }

    public Pregunta getPregunta5() {
        return pregunta5;
    }

    public void setPregunta5(Pregunta pregunta5) {
        this.pregunta5 = pregunta5;
    }

    public Pregunta getPregunta6() {
        return pregunta6;
    }

    public void setPregunta6(Pregunta pregunta6) {
        this.pregunta6 = pregunta6;
    }

    public Pregunta getPregunta7() {
        return pregunta7;
    }

    public void setPregunta7(Pregunta pregunta7) {
        this.pregunta7 = pregunta7;
    }

    public Pregunta getPregunta8() {
        return pregunta8;
    }

    public void setPregunta8(Pregunta pregunta8) {
        this.pregunta8 = pregunta8;
    }

    public Pregunta getPregunta9() {
        return pregunta9;
    }

    public void setPregunta9(Pregunta pregunta9) {
        this.pregunta9 = pregunta9;
    }

    public Pregunta getPregunta10() {
        return pregunta10;
    }

    public void setPregunta10(Pregunta pregunta10) {
        this.pregunta10 = pregunta10;
    }
}