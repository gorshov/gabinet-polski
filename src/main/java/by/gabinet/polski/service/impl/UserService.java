package by.gabinet.polski.service.impl;

import by.gabinet.polski.dao.BaseDaoInterface;
import by.gabinet.polski.dao.UserDaoInterface;
import by.gabinet.polski.dao.exception.DaoException;
import by.gabinet.polski.entity.User;
import by.gabinet.polski.service.UserServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by Александр Горшов on 03.08.2017  20:04.
 */
@Service
@Transactional
public class UserService extends BaseService<User> implements UserServiceInterface<User> {
    private static Logger log = Logger.getLogger(UserService.class);

    @Autowired
    @Qualifier("userDao")
    private UserDaoInterface userDaoInterface;

    @Override
    public User findByLogin(String login) {
        log.info("start service method findBylogin with param " + login);
        try {
            return userDaoInterface.findByLogin(login);
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public User findUserByLastName(String lastName) {
        log.info("start method findUserByName with last name " + lastName);
        try {
            return userDaoInterface.findUserByLastName(lastName);
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public User findUserByLoginAndPassword(String login, String password) {
        log.info("start method findUserByLoginAndPassword with login " + login);
        try {
            return userDaoInterface.findUserByLoginAndPassword(login, password);
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        log.info("start method deleteById with id " + id);
        try {
            userDaoInterface.deleteById(id);
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
        }
    }
}
