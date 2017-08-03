package by.gabinet.polski.dao;

import by.gabinet.polski.entity.User;

/**
 * Created by Александр Горшов on 03.08.2017  19:23.
 */
public interface UserDaoInterface<T> extends BaseDaoInterface<T> {

    User findByLogin(String login);
}
