package by.gabinet.polski.dao;

import by.gabinet.polski.entity.test.Test;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Александр Горшов on 11.08.2017  11:02.
 */
public interface TestDaoInterface<T> extends BaseDaoInterface<T> {

    void deleteById(Serializable id);

    List<Test> findTestByName(String testName);

}
