package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {

    @Column(name="nombre")
    private String nombre;

    @Column(name="username")
    private String username;

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

    @Column(name="profileimage")
    private byte[] image;

    @Column(name="avatarimage")
    private String avatar;

    @Column(name="userrole")
    private String userRole;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="profesor")
    @JsonIgnore
    private List<Clase> clases;


    @ManyToMany(mappedBy = "participantes", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Clase> clasePertany;


    public Usuario(){
    }

    public Usuario(String nombre,String username,String password,String email, String userRole) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setImage(byte[] image) { this.image = image; }

    public byte[] getImage() { return image; }

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
                ", username='" + username + '\'' +
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


}