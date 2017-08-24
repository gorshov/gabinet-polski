package by.gabinet.polski.service.impl;

import by.gabinet.polski.dao.CourseDaoInterface;
import by.gabinet.polski.entity.Course;
import by.gabinet.polski.entity.enumiration.Courses;
import by.gabinet.polski.service.CourseServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Александр Горшов on 20.08.2017  23:04.
 */
@Service
@Transactional
public class CourseService extends BaseService<Course> implements CourseServiceInterface<Course> {
    private static Logger log = Logger.getLogger(CourseService.class);

    @Autowired
    @Qualifier("courseDao")
    private CourseDaoInterface courseDaoInterface;

    @Override
    public void deleteById(Long id) {
        log.info("start service method deleteById with id " + id);
        courseDaoInterface.deleteById(id);
    }

    @Override
    public Course getCourseByName(String courseName) {
        log.info("start service method getCourseByName with name " + courseName);
        Courses courses = Courses.valueOf(courseName);
        Course course = courseDaoInterface.getCourseByName(courses);
        return course;
    }
}
