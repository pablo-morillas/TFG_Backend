package api.dto;


import java.io.Serializable;


public class InformeIDDTO implements Serializable{

    private String estudiantId;

    private String professorId;

    private String fecha;

    private InformeIDDTO(){}

    public InformeIDDTO(String estudiantId, String professorId, String fecha){
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
}
