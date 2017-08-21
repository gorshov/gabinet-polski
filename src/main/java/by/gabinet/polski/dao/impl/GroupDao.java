package by.gabinet.polski.dao.impl;

import by.gabinet.polski.dao.GroupDaoInterface;
import by.gabinet.polski.dao.exception.DaoException;
import by.gabinet.polski.entity.Group;
import by.gabinet.polski.entity.enumiration.Courses;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;


/**
 * Created by Александр Горшов on 07.08.2017  18:15.
 */
@Repository
public class GroupDao extends BaseDao<Group> implements GroupDaoInterface<Group> {
    private static Logger log = Logger.getLogger(GroupDao.class);


    @Autowired
    public GroupDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    @Override
    public List<Group> getGroupByCourseId(Serializable id) {
        log.info("start method getGroupByCourseId with id " + id);
        String queryGetGroupByCourseId = "from Group G where Course.id=:id";
        Query query = getSession().createQuery(queryGetGroupByCourseId).setParameter("id", id);
        return query.list();
    }

    @Override
    public List<Group> getGroupByCurrentQuarter(int numberQuarter) throws DaoException {
        log.info("start method getGroupByCurrentQuarter with number quarter " + numberQuarter);
        String queryGroupByCurrentQuarter = "from Group G where QUARTER(G.dateOfCource)=:numberQuarter";
        Query query = getSession().createQuery(queryGroupByCurrentQuarter).setParameter("numberQuarter", numberQuarter);
        return query.list();
    }

    @Override
    public List<Group> getBySetDate(Date dateOfCource) throws DaoException {
        log.info("start method getBySetDate with start date " + dateOfCource);
        Criteria criteria = getSession().createCriteria(Group.class);
        criteria.add(Restrictions.ge("dateOfCource", dateOfCource));
        criteria.addOrder(Order.asc("dateOfCource"));
        return criteria.list();
    }

    @Override
    public List<Group> getGroupByTime(Time time) throws DaoException {
        log.info("start method getGroupByTime with time " + time);
        Criteria criteria = getSession().createCriteria(Group.class);
        criteria.add(Restrictions.eq("timeStartCourse", time));
        criteria.addOrder(Order.asc("timeStartCourse"));
        return criteria.list();
    }

    @Override
    public List<Group> getGroupByTeacher(Long id) throws DaoException {
        log.info("start method getGroupByTeacher with id " + id);
        String queryGetGroupByTeacher = "from Group G where Teacher.id=:groupId";
        Query query = getSession().createQuery(queryGetGroupByTeacher).setParameter("groupId", id);
        return null;
    }

    @Override
    public List<Group> getGroupOnLastQuarter(int numberQuarter, int year) throws DaoException {
        log.info("start method getReportOnLastQuarter with number Quarter " + numberQuarter + " and year " + year);
        String queryGetByGroupOnLastQuarter = "SELECT * FROM group WHERE QUARTER(DATE_COURSE)=:numberQuarter GROUP BY DATE_COURSE =:year";
        SQLQuery query = getSession().createSQLQuery(queryGetByGroupOnLastQuarter);
        query.addEntity(Group.class);
        query.setParameter("numberQuarter", numberQuarter).setParameter("year", year);
        return query.list();
    }

    @Override
    public void deleteById(Serializable id) throws DaoException {
        log.info("start method deleteById with id " + id);
        String queryDeleteById = "delete from Group as G where G.id=:id";
        Query query = getSession().createQuery(queryDeleteById).setParameter("id", id);
        query.executeUpdate();
    }
}
