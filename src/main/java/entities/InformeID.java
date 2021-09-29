package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InformeID implements Serializable {
    @Column(name = "estudiant_email")
    private String estudiantId;

    @Column(name = "professor_email")
    private String professorId;

    private String fecha;

    private InformeID(){
    }

    public InformeID(String estudiantId, String professorId, String fecha){
        this.estudiantId = estudiantId;
        this.professorId = professorId;
        this.fecha = fecha;
    }

    public String getEstudiantId() {
        return estudiantId;
    }

    public void setEstudiantId(String estudiantId) {
        this.estudiantId = estudiantId;
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        InformeID that = (InformeID) o;
        return Objects.equals(estudiantId, that.estudiantId) &&
                Objects.equals(professorId, that.professorId) &&
                Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estudiantId, professorId, fecha);
    }
}