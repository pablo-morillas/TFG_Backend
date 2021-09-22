package api.dto;

public class UsuarioDTO {

    private String nombre;


    private String password;

    private String email;

    private String userRole;




    public UsuarioDTO() {
    }

    public UsuarioDTO(String nombre,String password,String email, String userRole) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
    }

    public UsuarioDTO(String email){
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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