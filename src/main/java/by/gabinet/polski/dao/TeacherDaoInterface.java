package by.gabinet.polski.dao;

import by.gabinet.polski.entity.Teacher;

import java.util.List;

/**
 * Created by Александр Горшов on 07.08.2017  13:05.
 */
public interface TeacherDaoInterface<T> extends BaseDaoInterface<T> {

    List<T> findGroupByTeacher(Class clazz);

    Teacher findTeacherByName(String name);

}
