package by.gabinet.polski.dao;

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

    List<Group> getGroupByCoursesName(Courses coursesName);

    List<Group> getGroupByCurrentQuarter(int numberQuarter);

    List<Group> getBySetDate(Date start, Date end);

    List<Group> getReportOnLastQuarter(int numberQuarter, int year);

    List<Group> getGroupByMonth(Date date);

    List<Group> getGroupByTime(Time time);

    List<Group> getGroupByTeacher(String lastName);

    void deleteById(Serializable id);
}
