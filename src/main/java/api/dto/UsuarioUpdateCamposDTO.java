package api.dto;

public class UsuarioUpdateCamposDTO {
    private String nombre;

    public UsuarioUpdateCamposDTO() {
    }

    public UsuarioUpdateCamposDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
