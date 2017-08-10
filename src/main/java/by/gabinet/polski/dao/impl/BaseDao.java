package by.gabinet.polski.dao.impl;

import by.gabinet.polski.dao.BaseDaoInterface;
import by.gabinet.polski.dao.exception.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Александр Горшов on 28.07.2017  12:07.
 */
@Repository
@Primary
public class BaseDao<T> implements BaseDaoInterface<T> {

    private static Logger log = Logger.getLogger(BaseDao.class);
    private SessionFactory sessionFactory;


    @Autowired
    public BaseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveOrUpdate(T entity) throws DaoException {
        log.info("start saveOrUpdate " + entity);
        getSession().saveOrUpdate(entity);
    }

    @Override
    public T getById(Class clazz, Serializable id) throws DaoException {
        log.info("start getById  method " + clazz + " with id " + id);
        return (T) getSession().get(clazz, id);
    }

    @Override
    public List<T> getAll(Class clazz) throws DaoException {
        log.info("start method getAll " + clazz);
        Criteria criteria = getSession().createCriteria(clazz);
        List<T> result = criteria.list();
        return result;
    }
}
