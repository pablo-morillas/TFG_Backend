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





    public UsuarioPuntosDTO() {
    }

    public UsuarioPuntosDTO(Usuario user) {
        this.email = user.getEmail();
        this.puntos = user.getPuntuacion();

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
