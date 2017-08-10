package by.gabinet.polski.dao.impl;

import by.gabinet.polski.dao.TeacherDaoInterface;
import by.gabinet.polski.dao.exception.DaoException;
import by.gabinet.polski.entity.Teacher;
import by.gabinet.polski.entity.enumiration.Courses;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Александр Горшов on 07.08.2017  13:42.
 */
@Repository
public class TeacherDao extends BaseDao<Teacher> implements TeacherDaoInterface<Teacher> {
    private static Logger log = Logger.getLogger(TeacherDao.class);

    @Autowired
    public TeacherDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Teacher> findTeacherByGroup(Courses coursesName) throws DaoException {
        log.info("start method findGroupByTeacher with courseName " + coursesName);
        /*String queryFindTeacherByGroup = "from Teacher as T where T.courseName=:coursesName";
        Query query = getSession().createQuery(queryFindTeacherByGroup).setParameter("coursesName", coursesName);*/
        Criteria criteria = getSession().createCriteria(Teacher.class);
        criteria.add(Restrictions.eq("courseName", coursesName.toString().toUpperCase()));
        return criteria.list();
    }

    @Override
    public Teacher findTeacherByName(String name) throws DaoException {
        Criteria criteria = getSession().createCriteria(Teacher.class);
        criteria.add(Restrictions.eq("lastName", name.toString().toUpperCase()));
        return (Teacher) criteria.uniqueResult();
    }

    @Override
    public void deleteById(Serializable id) throws DaoException {
        log.info("start method deleteById with id " + id);
        String queryDeleteById = "delete from Teacher as T where T.id=:id";
        Query query = getSession().createQuery(queryDeleteById).setParameter("id", id);
        query.executeUpdate();
    }
}
