package by.gabinet.polski.dao;

import by.gabinet.polski.entity.test.Test;

import java.util.List;

/**
 * Created by Александр Горшов on 11.08.2017  11:02.
 */
public interface TestDaoInterface<T> extends BaseDaoInterface<T> {

    List<Test> findTestByName(String testName);

}
