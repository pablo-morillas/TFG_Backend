package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="respuestas")
public class Respuesta implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="descripcion")
    private String desc;

    @Column(name="iscorrect")
    private boolean isCorrect;

    public Respuesta(){
    }

    public Respuesta(String desc, boolean isCorrect) {
        this.desc = desc;
        this.isCorrect = isCorrect;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                ", desc='" + desc + '\'' +
                ", iscorrect='" + isCorrect + '\'' +
                '}';
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}