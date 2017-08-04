package by.gabinet.polski.service.impl;

import by.gabinet.polski.dao.BaseDaoInterface;
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
        daoInterface.saveOrUpdate(entity);
    }

    public T getById(Class clazz, Serializable id) {
        log.info("start getById method " + clazz + " with id " + id);
        return (T) daoInterface.getById(clazz, id);
    }

    public List<T> getAll(Class clazz) {
        log.info("start getAll method " + clazz);
        List<T> list = daoInterface.getAll(clazz);
        return list;
    }

    public void deleteById(Class clazz, Serializable id) {
        log.info("start getById method " + clazz + " with id " + id);
    }
}
