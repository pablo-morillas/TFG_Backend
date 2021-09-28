package entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="informes")
public class Informe implements Serializable {

    @EmbeddedId
    private InformeID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("estudiantId")
    private Usuario estudiant;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("professorId")
    private Usuario professor;

    public Informe(){}




    @Override
    public String toString() {
        return "Test{" +
                ", id='" + id + '\'' +
                '}';
    }

    public InformeID getId() {
        return id;
    }
}