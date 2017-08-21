package by.gabinet.polski.dao.impl;

import by.gabinet.polski.dao.TestDaoInterface;
import by.gabinet.polski.entity.test.Test;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Александр Горшов on 11.08.2017  11:47.
 */
@Repository
public class TestDao extends BaseDao<Test> implements TestDaoInterface<Test> {
    private static Logger log = Logger.getLogger(TestDao.class);

    @Autowired
    public TestDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void deleteById(Serializable id) {
        log.info("start method deleteById");
        String queryDeleteByID = "delete from Test T where T.id=:id";
        Query query = getSession().createQuery(queryDeleteByID).setParameter("id", id);
        query.executeUpdate();

    }

    @Override
    public List<Test> findTestByName(String testName) {
        log.info("start method findTestByName " + testName);
        String queryFindTestByName = "from Test T where T.testName=:testName";
        Query query = getSession().createQuery(queryFindTestByName).setParameter("testName", testName);
        return query.list();
    }
}
