package entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="informes")
public class Informe implements Serializable {

    @EmbeddedId
    private InformeID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("estudiantId")
    private Usuario estudiant;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("professorId")
    private Usuario professor;

    @Column
    private int notaExercicis;

    @Column
    private int notaAtencio;

    @Column
    private int notaAssistencia;

    @Column
    private int notaTreball;

    public Informe(){}


    public Informe(int notaExercicis, int notaAtencio, int notaAssistencia, int notaTreball){
        this.notaExercicis = notaExercicis;
        this.notaAssistencia = notaAssistencia;
        this.notaAtencio = notaAtencio;
        this.notaTreball = notaTreball;
    }




    @Override
    public String toString() {
        return "Test{" +
                ", id='" + id + '\'' +
                '}';
    }

    public InformeID getId() {
        return id;
    }

    public void setId(InformeID id) {
        this.id = id;
    }

    public int getNotaExercicis() {
        return notaExercicis;
    }

    public void setNotaExercicis(int notaExercicis) {
        this.notaExercicis = notaExercicis;
    }

    public int getNotaAtencio() {
        return notaAtencio;
    }

    public void setNotaAtencio(int notaAtencio) {
        this.notaAtencio = notaAtencio;
    }

    public int getNotaAssistencia() {
        return notaAssistencia;
    }

    public void setNotaAssistencia(int notaAssistencia) {
        this.notaAssistencia = notaAssistencia;
    }

    public int getNotaTreball() {
        return notaTreball;
    }

    public void setNotaTreball(int notaTreball) {
        this.notaTreball = notaTreball;
    }
}