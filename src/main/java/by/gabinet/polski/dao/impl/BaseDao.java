package by.gabinet.polski.dao.impl;

import by.gabinet.polski.dao.BaseDaoInterface;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceContext;
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
    public void saveOrUpdate(T entity) {
        log.info("start saveOrUpdate " + entity);
        getSession().saveOrUpdate(entity);
    }

    @Override
    public T getById(Class clazz, Serializable id) {
        log.info("start getById  method " + clazz + " with id " + id);
        return (T) getSession().get(clazz, id);
    }

    @Override
    public List<T> getAll(Class clazz) {
        log.info("start method getAll " + clazz);
        Criteria criteria = getSession().createCriteria(clazz);
        List<T> result = criteria.list();
        return result;
    }

    @Override
    public void deleteById(Class clazz, Serializable id) {
        log.info("start method deleteById with id = " + id);
        String deleteByIdQuery = " delete from " + clazz.getClass() + " where " + clazz.getClass() + ".id=:id";
        Query queryDeleteById = getSession().createQuery(deleteByIdQuery).setParameter("id", id);
        queryDeleteById.executeUpdate();
    }
}
