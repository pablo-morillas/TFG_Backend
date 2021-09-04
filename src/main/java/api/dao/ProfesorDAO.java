package api.dao;

import entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository("profesorrepository")
public interface ProfesorDAO extends JpaRepository<Profesor, Serializable> {

    Profesor findByUsername(String username);
    Long deleteByEmail(String email);

    @Query("SELECT p FROM Profesor as p WHERE p.email = :email and p.password = :password")
    Profesor loginProfe(@Param("email") String email, @Param("password") String password);
}