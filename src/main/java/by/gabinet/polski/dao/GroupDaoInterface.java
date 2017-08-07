package by.gabinet.polski.dao;

import by.gabinet.polski.entity.Group;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by Александр Горшов on 07.08.2017  13:14.
 */
public interface GroupDaoInterface<T> extends BaseDaoInterface<T> {

    List<Group> getGroupByName(String groupName);

    List<Group> getGroupByQuarter(Date date);

    List<Group> getGroupByMonth(Date date);

    List<Group> getGroupByTime(Time time);

    void deleteById(Serializable id);
}
