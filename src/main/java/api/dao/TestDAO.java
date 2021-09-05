package api.dao;

import entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository("testrepository")
public interface TestDAO extends JpaRepository<Test, Serializable> {
}