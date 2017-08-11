package by.gabinet.polski.dao.impl;

import by.gabinet.polski.dao.QuestionDaoInterface;
import by.gabinet.polski.entity.test.Question;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Александр Горшов on 11.08.2017  11:49.
 */
@Repository
public class QuestionDao extends BaseDao<Question> implements QuestionDaoInterface<Question> {
    private static Logger log = Logger.getLogger(QuestionDao.class);

    @Autowired
    public QuestionDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
