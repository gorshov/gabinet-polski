package by.gabinet.polski.dao;

import java.io.Serializable;

/**
 * Created by Александр Горшов on 07.08.2017  13:13.
 */
public interface ScheduleDaoInterface<T> extends BaseDaoInterface<T> {

//    List<Schedule> getScheduleByDay(Date date);
//
//    List<Schedule> getScheduleByGroup(Group group);
//
//    List<Schedule> getScheduleOnMonth(Date date);

    void deleteById(Serializable id);

}
