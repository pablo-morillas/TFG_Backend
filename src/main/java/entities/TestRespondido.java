package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="testsRespondidos")
public class TestRespondido implements Serializable {

    @EmbeddedId
    private TestRespondidoID id;

    @Column(name="nota")
    private int nota;


    @Column(name="nomTest")
    private String nomTest;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("alumnoId")
    private Usuario alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("testId")
    private Test test;



    public TestRespondido(){
    }

    public TestRespondido(int nota, String nomTest) {
        this.nota = nota;
        this.nomTest = nomTest;
    }



    @Override
    public String toString() {
        return "Test{" +
                ", id='" + id + '\'' +
                ", nota='" + nota + '\'' +
                ", nomTest='" + nomTest + '\'' +
                '}';
    }


    public TestRespondidoID getId() {
        return id;
    }

    public void setId(TestRespondidoID id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setAlumno(Usuario alumno) {
        this.alumno = alumno;
    }

    public void setTest(Test test) {
        this.test = test;
    }


    public String getNomTest() {
        return nomTest;
    }

    public void setNomTest(String nomTest) {
        this.nomTest = nomTest;
    }
}