package api.services;

import entities.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public interface TestServices {
    boolean altaTest(Test test);
    boolean deleteTest(Test test);
    List<Test> findAllTest();
    Test findById(int id);
}
