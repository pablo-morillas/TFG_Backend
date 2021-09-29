package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="informes")
public class Informe implements Serializable {

    @EmbeddedId
    private InformeID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("estudiantId")
    @JsonIgnore
    private Usuario estudiant;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("professorId")
    @JsonIgnore
    private Usuario professor;

    @Column
    private int notaExercicis;

    @Column
    private int notaAtencio;

    @Column
    private int notaAssistencia;

    @Column
    private int notaTreball;

    @Column
    private String valoracions;

    public Informe(){}


    public Informe(int notaExercicis, int notaAtencio, int notaAssistencia, int notaTreball, String valoracions){
        this.notaExercicis = notaExercicis;
        this.notaAssistencia = notaAssistencia;
        this.notaAtencio = notaAtencio;
        this.notaTreball = notaTreball;
        this.valoracions = valoracions;
    }




    @Override
    public String toString() {
        return "Test{" +
                ", id='" + id + '\'' +
                ", notaExercicis='" + notaExercicis + '\'' +
                ", notaAtencio='" + notaAtencio + '\'' +
                ", notaAssistencia='" + notaAssistencia + '\'' +
                ", notaTreball='" + notaTreball + '\'' +
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

    public Usuario getEstudiant() {
        return estudiant;
    }

    public void setEstudiant(Usuario estudiant) {
        this.estudiant = estudiant;
    }

    public Usuario getProfessor() {
        return professor;
    }

    public void setProfessor(Usuario professor) {
        this.professor = professor;
    }

    public String getValoracions() {
        return valoracions;
    }

    public void setValoracions(String valoracions) {
        this.valoracions = valoracions;
    }
}