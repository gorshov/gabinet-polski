package by.gabinet.polski.dao;

import by.gabinet.polski.entity.Course;
import by.gabinet.polski.entity.enumiration.Courses;

import java.io.Serializable;

/**
 * Created by Александр Горшов on 18.08.2017  21:30.
 */
public interface CourseDaoInterface<T> extends BaseDaoInterface<T> {

    void deleteById(Serializable id);

    Course getCourseByName(Courses courseName);
}
