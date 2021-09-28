package api.dao;

import entities.Informe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository("informerepository")
public interface InformeDAO extends JpaRepository<Informe, Serializable> {
}