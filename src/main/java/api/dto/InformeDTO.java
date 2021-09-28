package api.dto;



public class InformeDTO {

    private InformeIDDTO id;

    public InformeDTO() {
    }

    public InformeDTO(InformeIDDTO id) {
        this.id = id;
    }

    public InformeIDDTO getId() {
        return id;
    }

    public void setId(InformeIDDTO id) {
        this.id = id;
    }
}

