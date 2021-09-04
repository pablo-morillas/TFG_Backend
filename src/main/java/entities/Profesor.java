package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "profesores")
public class Profesor extends Usuario{

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emailusuario", referencedColumnName = "email", insertable=false )
    @JsonIgnore
    private Set<Alumno> alumnos;

    public Profesor() {
        this.alumnos = new HashSet<>();
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void addAlumno(Alumno alumno) {
        this.alumnos.add(alumno);
    }

    public void removeAlumno(Alumno alumno) {
        this.alumnos.remove(alumno);
    }


}
