package api.services;

import api.dao.TestDAO;
import entities.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Optional;

import static com.tfg.Project.GestorUsuarios.validatePassword;

@Service("testservices")
@Transactional
public class TestServicesImpl implements TestServices {

    @Autowired
    @Qualifier("testrepository")
    private TestDAO testDAO;

    @Override
    public boolean altaTest(Test test) {
        return testDAO.save(test) != null;
    }


    @Override
    public boolean deleteTest(Test test) {
        testDAO.delete(test);
        return !testDAO.findById(test.getId()).isPresent();
    }


    @Override
    public List<Test> findAllTest() {
        return testDAO.findAll();
    }

    @Override
    public Test findById(int id) {
        Test testfind = null;
        Optional<Test> test = testDAO.findById(id);
        if (test.isPresent()) testfind = test.get();
        return  testfind;
    }

}
