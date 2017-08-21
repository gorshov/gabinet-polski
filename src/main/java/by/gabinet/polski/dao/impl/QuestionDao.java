package by.gabinet.polski.dao.impl;

import by.gabinet.polski.dao.QuestionDaoInterface;
import by.gabinet.polski.entity.test.Question;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

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

    @Override
    public void deleteById(Serializable id) {
        log.info("start method deleteById");
        String queryDeleteByID = "delete from Question Q where Q.id=:id";
        Query query = getSession().createQuery(queryDeleteByID).setParameter("id", id);
        query.executeUpdate();
    }
}
