package by.gabinet.polski.dao;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Александр Горшов on 27.07.2017  20:45.
 */

public interface BaseDaoInterface<T> {

    void saveOrUpdate(T entity);

    T getById(Class clazz, Serializable id);

    List<T> getAll(Class clazz);

    void deleteById(Class clazz, Serializable id);
}
