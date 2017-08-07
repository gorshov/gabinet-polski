package by.gabinet.polski.dao.impl;

import by.gabinet.polski.dao.GroupDaoInterface;
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
    public List<Group> getGroupByCoursesName(Courses coursesName) {
        log.info("start method getGroupByCoursesName with courses name " + coursesName);
        Criteria criteria = getSession().createCriteria(Group.class);
        criteria.add(Restrictions.eq("courseName", coursesName.toString().toUpperCase()));
        List<Group> groupList = criteria.list();
        return groupList;
    }

    @Override
    public List<Group> getGroupByCurrentQuarter(int numberQuarter) {
        log.info("start method getReportOnCurrentQuarter with parameters : " + numberQuarter);
        String getByReportOnCurrentQuarter = "from Group G where QUARTER(G.startDate)=:numberQuarter";
        Query query = getSession().createQuery(getByReportOnCurrentQuarter).setParameter("numberQuarter", numberQuarter);
        List<Group> reportList = query.list();
        return null;
    }

    @Override
    public List<Group> getBySetDate(Date start, Date end) {
        return null;
    }

    @Override
    public List<Group> getGroupByMonth(Date date) {
        return null;
    }

    @Override
    public List<Group> getGroupByTime(Time time) {
        return null;
    }

    @Override
    public List<Group> getGroupByTeacher(String lastName) {
        log.info("start method getGroupByTeacher with lastName " + lastName);

        return null;
    }

    @Override
    public List<Group> getReportOnLastQuarter(int numberQuarter, int year) {
        return null;
    }

    @Override
    public void deleteById(Serializable id) {
        log.info("start method deleteById with id " + id);
        String queryDeleteById = "delete from Group as G where G.id=:id";
        Query query = getSession().createQuery(queryDeleteById).setParameter("id", id);
        query.executeUpdate();
    }
}
