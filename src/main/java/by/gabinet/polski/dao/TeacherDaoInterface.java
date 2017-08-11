package by.gabinet.polski.dao;

import by.gabinet.polski.dao.exception.DaoException;
import by.gabinet.polski.entity.Teacher;
import by.gabinet.polski.entity.enumiration.Courses;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Александр Горшов on 07.08.2017  13:05.
 */
public interface TeacherDaoInterface<T> extends BaseDaoInterface<T> {

    List<T> findTeacherByCoursesName(Courses coursesName) throws DaoException;

    Teacher findTeacherByName(String name) throws DaoException;

    void deleteById(Serializable id) throws DaoException;

}
