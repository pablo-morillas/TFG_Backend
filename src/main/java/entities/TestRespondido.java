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

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("alumnoId")
    private Usuario alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("testId")
    private Test test;



    public TestRespondido(){
    }

    public TestRespondido(int nota) {
        this.nota = nota;
    }



    @Override
    public String toString() {
        return "Test{" +
                ", id='" + id + '\'' +
                ", nota='" + nota + '\'' +
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
}