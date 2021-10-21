package api.dto;



public class TestRespondidoDTO {

    private TestRespondidoIDDTO id;

    private int nota;

    private String nomTest;

    public TestRespondidoDTO() {
    }

    public TestRespondidoDTO(TestRespondidoIDDTO id, int nota, String nomTest) {
        this.id = id;
        this.nota = nota;
        this.nomTest = nomTest;
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

    public String getNomTest() {
        return nomTest;
    }

    public void setNomTest(String nomTest) {
        this.nomTest = nomTest;
    }
}

