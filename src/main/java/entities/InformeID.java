package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class InformeID implements Serializable {
    @Column(name = "estudiant_email")
    private String estudiantId;

    @Column(name = "professor_email")
    private String professorId;

    private Date fecha;

    private InformeID(){
        this.fecha = new Date();
    }

    public InformeID(String estudiantId, String professorId){
        this.estudiantId = estudiantId;
        this.professorId = professorId;
        this.fecha = new Date();
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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