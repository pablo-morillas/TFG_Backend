package api.dto;


public class UsuarioInfoProfessorDTO {

    private int numEstudiants;

    private int numClasses;





    public UsuarioInfoProfessorDTO() {
    }

    public UsuarioInfoProfessorDTO(int numEstudiants, int numClasses) {
        this.numEstudiants = numEstudiants;
        this.numClasses = numClasses;
    }

    public int getNumEstudiants() {
        return numEstudiants;
    }

    public void setNumEstudiants(int numEstudiants) {
        this.numEstudiants = numEstudiants;
    }

    public int getNumClasses() {
        return numClasses;
    }

    public void setNumClasses(int numClasses) {
        this.numClasses = numClasses;
    }
}
