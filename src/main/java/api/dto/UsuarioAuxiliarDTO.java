package api.dto;


import entities.Usuario;


import java.util.ArrayList;
import java.util.List;

public class UsuarioAuxiliarDTO {
    private String nombre;

    private String username;

    private String email;

    private String userRole;


    private int nivel;

    private int puntos;


    public UsuarioAuxiliarDTO() {
    }

    public UsuarioAuxiliarDTO(Usuario user) {
        this.nombre = user.getNombre();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.userRole = user.getUserRole();
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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
