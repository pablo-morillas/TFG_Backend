package api.dto;


import java.io.Serializable;


public class InformeIDDTO implements Serializable{

    private String estudiantId;

    private String professorId;

    private InformeIDDTO(){}

    public InformeIDDTO(String estudiantId, String professorId){
        this.estudiantId = estudiantId;
        this.professorId = professorId;
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
}
