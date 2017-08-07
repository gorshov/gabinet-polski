package by.gabinet.polski.dao;

import by.gabinet.polski.entity.Schedule;

import java.sql.Date;
import java.util.List;

/**
 * Created by Александр Горшов on 07.08.2017  13:13.
 */
public interface ScheduleDaoInterface<T> extends BaseDaoInterface<T> {

    List<Schedule> getScheduleByDay(Date date);

}
