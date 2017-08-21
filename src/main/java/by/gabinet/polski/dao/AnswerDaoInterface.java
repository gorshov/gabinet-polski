package by.gabinet.polski.dao;

import java.io.Serializable;

/**
 * Created by Александр Горшов on 11.08.2017  11:13.
 */
public interface AnswerDaoInterface<T> extends BaseDaoInterface<T> {
    void deleteById(Serializable id);
}
