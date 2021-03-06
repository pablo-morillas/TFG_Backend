package api.dto;


import entities.Usuario;

public class UsuarioPuntosDTO {

    private String email;

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }


    private int puntos;

    private int maxPuntos;

    private int testsRealizados;

    private int testsPendientes;





    public UsuarioPuntosDTO() {
    }

    public UsuarioPuntosDTO(Usuario user) {
        this.email = user.getEmail();
        this.puntos = user.getPuntuacion();
        this.maxPuntos = user.getMaxpuntuacion();
        this.testsRealizados = user.getTestsRealizados();
        this.testsPendientes = user.getTestsPendientes();
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMaxPuntos() {
        return maxPuntos;
    }

    public void setMaxPuntos(int maxPuntos) {
        this.maxPuntos = maxPuntos;
    }

    public int getTestsRealizados() {
        return testsRealizados;
    }

    public void setTestsRealizados(int testsRealizados) {
        this.testsRealizados = testsRealizados;
    }

    public int getTestsPendientes() {
        return testsPendientes;
    }

    public void setTestsPendientes(int testsPendientes) {
        this.testsPendientes = testsPendientes;
    }
}
