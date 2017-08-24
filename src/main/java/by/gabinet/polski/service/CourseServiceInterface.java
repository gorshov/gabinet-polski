package by.gabinet.polski.service;

import by.gabinet.polski.entity.Course;

/**
 * Created by Александр Горшов on 20.08.2017  23:02.
 */
public interface CourseServiceInterface<T> extends BaseServiceInterface<T> {

    void deleteById(Long id);

    Course getCourseByName(String courseName);
}
