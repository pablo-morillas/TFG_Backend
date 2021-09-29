package api.dto;


import java.io.Serializable;
import java.util.Date;


public class InformeIDDTO implements Serializable{

    private String estudiantId;

    private String professorId;

    private Date fecha;

    private InformeIDDTO(){}

    public InformeIDDTO(String estudiantId, String professorId, Date fecha){
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
