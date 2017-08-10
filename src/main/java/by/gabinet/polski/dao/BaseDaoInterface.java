package by.gabinet.polski.dao;

import by.gabinet.polski.dao.exception.DaoException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Александр Горшов on 27.07.2017  20:45.
 */

public interface BaseDaoInterface<T> {

    void saveOrUpdate(T entity) throws DaoException;

    T getById(Class clazz, Serializable id) throws DaoException;

    List<T> getAll(Class clazz) throws DaoException;

}
