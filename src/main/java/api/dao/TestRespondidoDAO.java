package api.dao;

import entities.Test;
import entities.TestRespondido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository("testrespondidorepository")
public interface TestRespondidoDAO extends JpaRepository<TestRespondido, Serializable> {
}