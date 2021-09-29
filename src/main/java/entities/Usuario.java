package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {

   // @JsonIgnoreProperties(ignoreUnknown = true,
    //        value = {"clasesPertany"})


    @Column(name="nombre")
    private String nombre;


    @Id
    @Column(name="email")
    private String email;

    @Column(name="password")
    @JsonIgnore
    private String password;

    @Column(name="puntuación")
    private int puntuacion = 0;

    @Column(name="maxpuntuación")
    private int maxPuntuacion = 0;

    @Column(name="testsrealizados")
    private int testsRealizados = 0;

    @Column(name="testspendientes")
    private int testsPendientes = 0;

    @Column(name="userrole")
    private String userRole;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="profesor")
    @JsonIgnore
    private List<Clase> clases;


    @ManyToMany(mappedBy = "alumnos", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<Clase> clasePertany;

    @OneToMany(
            mappedBy = "alumno",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<TestRespondido> testRespondidos = new ArrayList<>();

    @OneToMany(
            mappedBy = "estudiant",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<Informe> informesRecibidos = new ArrayList<>();

    @OneToMany(
            mappedBy = "professor",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Informe> informesHechos = new ArrayList<>();


    public Usuario(){
    }

    public Usuario(String nombre,String password,String email, String userRole) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
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


    @Override
    public String toString() {
        return "Usuario{" +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userrole='" + userRole + '\'' +
                '}';
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void addClase(Clase clase) {
        this.clases.add(clase);
    }

    @JsonIgnore
    public List<Clase> getClasesPertany() {
        return clasePertany;
    }

    public void addClasePertany(Clase clase) {
        this.clasePertany.add(clase);
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getMaxpuntuacion() {
        return maxPuntuacion;
    }

    public void setMaxpuntuacion(int maxPuntuacion) {
        this.maxPuntuacion = maxPuntuacion;
    }

    public int getTestsRealizados() {
        return testsRealizados;
    }

    public void addTestsRealizados() {
        this.testsRealizados++;
    }

    public int getTestsPendientes() {
        return testsPendientes;
    }

    public void addTestsPendientes() {
        this.testsPendientes++;
    }


    public List<TestRespondido> getTestRespondidos() {
        return testRespondidos;
    }

    public void addTestRespondidos(TestRespondido testRespondido) {
        this.testRespondidos.add(testRespondido);
    }

    public List<Informe> getInformesRecibidos() {
        return informesRecibidos;
    }

    public List<Informe> getInformesHechos() {
        return informesHechos;
    }

    public void addInformesRecibidos(Informe informe) {
        this.informesRecibidos.add(informe);
    }

    public void addInformesHechos(Informe informe) {
        this.informesHechos.add(informe);
    }

}