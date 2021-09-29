package api.services;

import api.dao.TestRespondidoDAO;
import entities.TestRespondido;
import entities.TestRespondidoID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("testrespondidoservices")
@Transactional
public class TestRespondidoImpl implements TestRespondidoServices {

    @Autowired
    @Qualifier("testrespondidorepository")
    private TestRespondidoDAO testRespondidoDAO;




    @Override
    public boolean altaTestRespondido(TestRespondido testRespondido) {
        return testRespondidoDAO.save(testRespondido) != null;
    }

    @Override
    public boolean deleteTestRespondido(TestRespondido testRespondido) {
        testRespondidoDAO.delete(testRespondido);
        return !testRespondidoDAO.findById(testRespondido.getId()).isPresent();
    }

    @Override
    public List<TestRespondido> findAllTest() {
        return testRespondidoDAO.findAll();
    }

    @Override
    public TestRespondido findById(TestRespondidoID id) {
        TestRespondido testfind = null;
        Optional<TestRespondido> test = testRespondidoDAO.findById(id);
        if (test.isPresent()) testfind = test.get();
        return  testfind;
    }

}
