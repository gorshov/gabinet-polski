package by.gabinet.polski.dao;

import by.gabinet.polski.dao.exception.DaoException;
import by.gabinet.polski.entity.Group;
import by.gabinet.polski.entity.enumiration.Courses;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by Александр Горшов on 07.08.2017  13:14.
 */
public interface GroupDaoInterface<T> extends BaseDaoInterface<T> {

    List<Group> getGroupByCoursesName(Courses coursesName) throws DaoException;

    List<Group> getGroupByCurrentQuarter(int numberQuarter) throws DaoException;

    List<Group> getBySetDate(Date dateOfCource) throws DaoException;

    List<Group> getReportOnLastQuarter(int numberQuarter, int year) throws DaoException;


    List<Group> getGroupByTime(Time time) throws DaoException;

    List<Group> getGroupByTeacher(Long id) throws DaoException;

    void deleteById(Serializable id) throws DaoException;
}
