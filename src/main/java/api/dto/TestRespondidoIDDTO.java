package api.dto;


import java.io.Serializable;
import java.util.Objects;


public class TestRespondidoIDDTO implements Serializable{

    private String alumnoId;

    private int testId;

    private TestRespondidoIDDTO(){}

    public TestRespondidoIDDTO(String alumnoId, int testId){
        this.alumnoId = alumnoId;
        this.testId = testId;
    }


    public String getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(String alumnoId) {
        this.alumnoId = alumnoId;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

}
