package api.dto;


import entities.Usuario;


import java.util.ArrayList;
import java.util.List;

public class UsuarioAuxiliarDTO {
    private String nombre;

    private String username;


    private String email;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    private String avatar;

    private int nivel;

    private int puntos;

    private byte[] image;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


    public UsuarioAuxiliarDTO() {
    }

    public UsuarioAuxiliarDTO(Usuario user) {
        this.nombre = user.getNombre();
        this.username = user.getUsername();
        this.email = user.getEmail();
//        this.nivel = user.getNivel();
//        this.puntos = user.getPuntos();
        this.avatar = user.getAvatar();
        this.image = user.getImage();
        this.avatar = user.getAvatar();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
