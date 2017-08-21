package by.gabinet.polski.dao.impl;

import by.gabinet.polski.dao.CourseDaoInterface;
import by.gabinet.polski.entity.Course;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Александр Горшов on 18.08.2017  21:33.
 */
@Repository
public class CourseDao extends BaseDao<Course> implements CourseDaoInterface<Course> {
    private static Logger log = Logger.getLogger(CourseDao.class);

    @Autowired
    public CourseDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void deleteById(Serializable id) {
        log.info("start DAO method deleteById with id " + id);
        String queryDeleteById = "delete from Course C where C.id=:id";
        Query query = getSession().createQuery(queryDeleteById).setParameter("id", id);
        query.executeUpdate();
    }
}
