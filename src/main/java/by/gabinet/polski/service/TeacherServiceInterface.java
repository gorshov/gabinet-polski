package by.gabinet.polski.service;

import by.gabinet.polski.dao.exception.DaoException;
import by.gabinet.polski.entity.Teacher;
import by.gabinet.polski.entity.enumiration.Courses;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Александр Горшов on 11.08.2017  18:07.
 */
public interface TeacherServiceInterface<T> extends BaseServiceInterface<T> {

    List<T> findTeacherByCoursesName(Courses coursesName) throws DaoException;

    Teacher findTeacherByName(String name) throws DaoException;

    void deleteById(Serializable id) throws DaoException;
}
