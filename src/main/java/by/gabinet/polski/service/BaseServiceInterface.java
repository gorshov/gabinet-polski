package by.gabinet.polski.service;

import by.gabinet.polski.dao.exception.DaoException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Александр Горшов on 31.07.2017  9:33.
 */
public interface BaseServiceInterface<T> {

    void saveOrUpdate(T entity);

    T getById(Class clazz, Serializable id);

    List<T> getAll(Class clazz) throws DaoException;

}
