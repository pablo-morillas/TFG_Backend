package api.services;


import entities.TestRespondido;
import entities.TestRespondidoID;

import java.util.List;

public interface TestRespondidoServices {
    boolean altaTestRespondido(TestRespondido testRespondido);
    boolean deleteTestRespondido(TestRespondido testRespondido);
    List<TestRespondido> findAllTest();
    TestRespondido findById(TestRespondidoID id);
}
