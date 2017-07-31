package by.gabinet.polski.service.impl;

import by.gabinet.polski.dao.BaseDaoInterface;
import by.gabinet.polski.service.BaseServiceInterface;
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

    @Autowired
    protected BaseDaoInterface<T> daoInterface;

    @Autowired
    public BaseService() {
    }

    public void saveOrUpdate(T entity) {

    }

    public T getById(Class clazz, Serializable id) {
        return null;
    }

    public List<T> getAll(Class clazz) {
        return null;
    }

    public void deleteById(Class clazz, Serializable id) {

    }
}
