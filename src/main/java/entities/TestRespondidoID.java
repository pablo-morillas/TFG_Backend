package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TestRespondidoID implements Serializable{
    @Column(name = "alumno_email")
    private String alumnoId;

    @Column(name = "test_id")
    private int testId;

    private TestRespondidoID(){}

    public TestRespondidoID(String alumnoId, int testId){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        TestRespondidoID that = (TestRespondidoID) o;
        return Objects.equals(alumnoId, that.alumnoId) &&
                Objects.equals(testId, that.testId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alumnoId, testId);
    }
}
