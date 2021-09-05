package api.dao;

import entities.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository("preguntarepository")
public interface PreguntaDAO extends JpaRepository<Pregunta, Serializable> {
}