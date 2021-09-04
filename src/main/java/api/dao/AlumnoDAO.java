package api.dao;

import entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository("alumnorepository")
public interface AlumnoDAO extends JpaRepository<Alumno, Serializable> {

    Alumno findByUsername(String username);
    Long deleteByEmail(String email);

    @Query("SELECT u FROM Alumno as u WHERE u.email = :email and u.password = :password")
    Alumno loginAlumn(@Param("email") String email, @Param("password") String password);
}