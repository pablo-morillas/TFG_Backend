package api.dto;


import entities.Usuario;

public class AlumnoAssistenteDTO {
    private String alumnoAssistenteEmail;

    private int ClaseId;


    public AlumnoAssistenteDTO() {
    }

    public AlumnoAssistenteDTO(String alumnoAssistenteEmail, int ClaseId) {
        this.alumnoAssistenteEmail = alumnoAssistenteEmail;
        this.ClaseId = ClaseId;
    }


    public String getAlumnoAssistenteEmail() {
        return alumnoAssistenteEmail;
    }

    public void setAlumnoAssistenteEmail(String alumnoAssistenteEmail) {
        this.alumnoAssistenteEmail = alumnoAssistenteEmail;
    }

    public int getClaseId() {
        return ClaseId;
    }

    public void setClaseId(int claseId) {
        ClaseId = claseId;
    }
}
