package api.dto;



public class TestRespondidoDTO {

    private TestRespondidoIDDTO id;

    private int nota;

    public TestRespondidoDTO() {
    }

    public TestRespondidoDTO(TestRespondidoIDDTO id, int nota) {
        this.id = id;
        this.nota = nota;
    }

    public TestRespondidoIDDTO getId() {
        return id;
    }

    public void setId(TestRespondidoIDDTO id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}

