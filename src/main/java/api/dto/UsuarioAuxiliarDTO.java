package api.dto;


import entities.Usuario;

public class UsuarioAuxiliarDTO {
    private String nombre;


    private String email;

    private String userRole;



    public UsuarioAuxiliarDTO() {
    }

    public UsuarioAuxiliarDTO(Usuario user) {
        this.nombre = user.getNombre();
        this.email = user.getEmail();
        this.userRole = user.getUserRole();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
