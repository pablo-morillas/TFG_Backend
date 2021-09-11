package api.dao;

import entities.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository("claserepository")
public interface ClaseDAO extends JpaRepository<Clase, Serializable> {
}