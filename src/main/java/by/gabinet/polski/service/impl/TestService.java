package by.gabinet.polski.service.impl;

import by.gabinet.polski.dao.TestDaoInterface;
import by.gabinet.polski.entity.test.Test;
import by.gabinet.polski.service.TestServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Александр Горшов on 14.08.2017  16:38.
 */
@Service
@Transactional
public class TestService extends BaseService<Test> implements TestServiceInterface<Test> {
    private static Logger log = Logger.getLogger(TestService.class);

    @Autowired
    @Qualifier("testDao")
    private TestDaoInterface testDaoInterface;

    @Override
    public void deleteById(Long id) {
        log.info("start service-method deleteById with id " + id);
        testDaoInterface.deleteById(id);
    }

    @Override
    public List<Test> findTestByName(String testName) {
        log.info("start service method findTestByName with name " + testName);
        List<Test> testList = testDaoInterface.findTestByName(testName);
        return testList;
    }
}
