package by.gabinet.polski.dao.impl;

import by.gabinet.polski.dao.UserDaoInterface;
import by.gabinet.polski.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public User findUserByName(String userName) {
        return null;
    }

    @Override
    public User findUserByLoginAndPassword(String login, String password) {
        return null;
    }
}
