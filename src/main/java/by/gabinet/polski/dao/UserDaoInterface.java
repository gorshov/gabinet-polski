package by.gabinet.polski.dao;

import by.gabinet.polski.dao.exception.DaoException;
import by.gabinet.polski.entity.User;

import java.io.Serializable;

/**
 * Created by Александр Горшов on 03.08.2017  19:23.
 */
public interface UserDaoInterface<T> extends BaseDaoInterface<T> {

    User findByLogin(String login) throws DaoException;

    User findUserByLastName(String lastName) throws DaoException;

    User findUserByLoginAndPassword(String login, String password) throws DaoException;

    void deleteById(Serializable id) throws DaoException;
}
