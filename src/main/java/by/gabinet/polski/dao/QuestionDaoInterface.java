package by.gabinet.polski.dao;

import org.apache.log4j.Logger;

import java.io.Serializable;

/**
 * Created by Александр Горшов on 11.08.2017  11:06.
 */
public interface QuestionDaoInterface<T> extends BaseDaoInterface<T> {
    void deleteById(Serializable id);
}
