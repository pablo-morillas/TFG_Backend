package api.dto;

public class AlumnoAssistenteDTO {

    private String alumnoAssistenteEmail;

    private int claseId;


    public AlumnoAssistenteDTO() {
    }

    public AlumnoAssistenteDTO(String alumnoAssistenteEmail, int claseId) {
        this.alumnoAssistenteEmail = alumnoAssistenteEmail;
        this.claseId = claseId;
    }


    public String getAlumnoAssistenteEmail() {
        return alumnoAssistenteEmail;
    }

    public void setAlumnoAssistenteEmail(String alumnoAssistenteEmail) {
        this.alumnoAssistenteEmail = alumnoAssistenteEmail;
    }

    public int getClaseId() {
        return claseId;
    }

    public void setClaseId(int claseId) {
        this.claseId = claseId;
    }
}
