package by.gabinet.polski.service;

import by.gabinet.polski.entity.test.Test;

import java.util.List;

/**
 * Created by Александр Горшов on 11.08.2017  18:06.
 */
public interface TestServiceInterface<T> extends BaseServiceInterface<T> {
    void deleteById(Long id);

    List<Test> findTestByName(String testName);
}
