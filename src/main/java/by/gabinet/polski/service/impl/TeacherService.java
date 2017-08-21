package by.gabinet.polski.service.impl;

import by.gabinet.polski.dao.TeacherDaoInterface;
import by.gabinet.polski.dao.exception.DaoException;
import by.gabinet.polski.entity.Teacher;
import by.gabinet.polski.entity.enumiration.Courses;
import by.gabinet.polski.service.TeacherServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Александр Горшов on 11.08.2017  18:33.
 */
@Service
@Transactional
public class TeacherService extends BaseService<Teacher> implements TeacherServiceInterface<Teacher> {
    private static Logger log = Logger.getLogger(TeacherService.class);

    @Autowired
    @Qualifier("teacherDao")
    private TeacherDaoInterface teacherDaoInterface;

    @Override
    public List<Teacher> findTeacherByCoursesName(Courses coursesName) {
        log.info("start method findTeacherByCoursesName with name " + coursesName);
        List<Teacher> teacherList = null;
        try {
            teacherList = teacherDaoInterface.findTeacherByCoursesName(coursesName);
            return teacherList;
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public Teacher findTeacherByName(String name) {
        log.info("start method findTeacherByName with name " + name);
        Teacher teacher = null;
        try {
            teacher = teacherDaoInterface.findTeacherByName(name);
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
            return null;
        }
        return teacher;
    }

    @Override
    public void deleteById(Serializable id) {
        log.info("start method deleteById with id " + id);
        try {
            teacherDaoInterface.deleteById(id);
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
        }
    }
}
