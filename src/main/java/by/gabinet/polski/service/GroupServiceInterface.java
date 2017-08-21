package by.gabinet.polski.service;

import by.gabinet.polski.dao.exception.DaoException;
import by.gabinet.polski.entity.Group;
import by.gabinet.polski.entity.enumiration.Courses;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by Александр Горшов on 11.08.2017  18:10.
 */
public interface GroupServiceInterface<T> extends BaseServiceInterface<T> {
    
    List<Group> getGroupByCourseId(Long id);

    List<Group> getGroupByCurrentQuarter() throws DaoException;

    List<Group> getBySetDate(String dateOfCourse) throws DaoException;

    List<Group> getGroupOnLastQuarter() throws DaoException;

    List<Group> getGroupByTime(String time) throws DaoException;

    List<Group> getGroupByTeacher(Long id) throws DaoException;

    void deleteById(Serializable id) throws DaoException;
}
