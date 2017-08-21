package by.gabinet.polski.service.impl;

import by.gabinet.polski.dao.BaseDaoInterface;
import by.gabinet.polski.dao.exception.DaoException;
import by.gabinet.polski.service.BaseServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Александр Горшов on 31.07.2017  10:01.
 */
@Service
@Transactional
public class BaseService<T> implements BaseServiceInterface<T> {
    private static Logger log = Logger.getLogger(BaseService.class);

    @Autowired
    @Qualifier("baseDao")
    protected BaseDaoInterface<T> daoInterface;

    public BaseService() {
    }

    @Autowired
    public BaseService(BaseDaoInterface<T> baseDaoInterface) {
        this.daoInterface = daoInterface;
    }

    public void saveOrUpdate(T entity) {
        log.info("start saveOrUpdate method " + entity);
        try {
            daoInterface.saveOrUpdate(entity);
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
        }
    }

    public T getById(Class clazz, Serializable id) {
        log.info("start getById method " + clazz + " with id " + id);
        try {
            return (T) daoInterface.getById(clazz, id);
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public List<T> getAll(Class clazz) throws DaoException {
        log.info("start getAll method " + clazz);
        List<T> list =  daoInterface.getAll(clazz);
        return list;
    }
}
