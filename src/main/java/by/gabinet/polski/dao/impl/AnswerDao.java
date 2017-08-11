package by.gabinet.polski.dao.impl;

import by.gabinet.polski.dao.AnswerDaoInterface;
import by.gabinet.polski.entity.test.Answer;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Александр Горшов on 11.08.2017  11:51.
 */
@Repository
public class AnswerDao extends BaseDao<Answer> implements AnswerDaoInterface<Answer> {
    private static Logger log = Logger.getLogger(AnswerDao.class);

    @Autowired
    public AnswerDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
