package by.gabinet.polski.service;

import by.gabinet.polski.entity.User;

import java.io.Serializable;

/**
 * Created by Александр Горшов on 03.08.2017  20:03.
 */
public interface UserServiceInterface<T> extends BaseServiceInterface<T> {

    User findByLogin(String login);

    User findUserByLastName(String lastName);

    User findUserByLoginAndPassword(String login, String password);

    void deleteById(Serializable id);
}
