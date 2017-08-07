package by.gabinet.polski.dao.impl;

import by.gabinet.polski.dao.UserDaoInterface;
import by.gabinet.polski.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Александр Горшов on 03.08.2017  19:41.
 */
@Repository
public class UserDao extends BaseDao<User> implements UserDaoInterface<User> {
    private static Logger log = Logger.getLogger(UserDao.class);

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public User findByLogin(String login) {
        log.info("start method findByLogin with login " + login);
        String queryFindByLogin = "from User as U where U.login=:login";
        Query query = getSession().createQuery(queryFindByLogin).setParameter("login", login);
        return (User) query.uniqueResult();
    }

    @Override
    public User findUserByLastName(String lastName) {
        log.info("start method findUserByName with last name " + lastName);
        String queryFindUserByLastName = "from User as U where U.lastName=:lastName";
        Query query = getSession().createQuery(queryFindUserByLastName).setParameter("lastName", lastName);
        return (User) query.uniqueResult();
    }

    @Override
    public User findUserByLoginAndPassword(String login, String password) {
        log.info("start method findUserByLoginAndPassword with login " + login);
        String queryFindUserByLoginAndPassword = "from User as U where U.login=:login and U.password=:password";
        Query query = getSession().createQuery(queryFindUserByLoginAndPassword).setParameter("login", login).setParameter("password", password);
        return (User) query.uniqueResult();
    }

    @Override
    public void deleteById(Serializable id) {
        log.info("start method deleteById with id " + id);
        String queryDeleteById = "delete from User as U where U.id=:id";
        Query query = getSession().createQuery(queryDeleteById).setParameter("id", id);
        query.executeUpdate();
    }
}
