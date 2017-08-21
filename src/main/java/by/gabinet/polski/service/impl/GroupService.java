package by.gabinet.polski.service.impl;

import by.gabinet.polski.dao.GroupDaoInterface;
import by.gabinet.polski.dao.exception.DaoException;
import by.gabinet.polski.entity.Group;
import by.gabinet.polski.entity.enumiration.Courses;
import by.gabinet.polski.service.GroupServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

/**
 * Created by Александр Горшов on 11.08.2017  18:55.
 */
@Service
@Transactional
public class GroupService extends BaseService<Group> implements GroupServiceInterface<Group> {
    private static Logger log = Logger.getLogger(GroupService.class);

    @Autowired
    @Qualifier("groupDao")
    private GroupDaoInterface groupDaoInterface;

    @Override
    public List<Group> getGroupByCourseId(Long id) {
        log.info("start service method getGroupByCourseId with id " + id);
        List<Group> groupList = groupDaoInterface.getGroupByCourseId(id);
        return groupList;
    }

    @Override
    public List<Group> getGroupByCurrentQuarter() {
        log.info("Start method getGroupByCurrentQuarter ");
        int quarterNumber = getQuarterNumber();
        List<Group> groupList = null;
        try {
            groupList = groupDaoInterface.getGroupByCurrentQuarter(quarterNumber);
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
        }
        return groupList;
    }

    /**
     * This method count quarter by number of month from getGroupOnCurrentQuarter method.
     *
     * @return quarter number
     */
    private int getQuarterNumber() {
        log.info("Start method getQuarterNumber ");
        LocalDate today = LocalDate.now();
        int numberOfMonth = today.getMonthValue();
        int quarterNumber = 0;
        if (numberOfMonth <= 3) {
            quarterNumber = 1;
        } else if (numberOfMonth >= 4 && numberOfMonth <= 6) {
            quarterNumber = 2;
        } else if (numberOfMonth >= 7 && numberOfMonth <= 9) {
            quarterNumber = 3;
        } else if (numberOfMonth >= 10 && numberOfMonth <= 12) {
            quarterNumber = 4;
        }
        return quarterNumber;
    }

    @Override
    public List<Group> getBySetDate(String dateOfCourse) throws DaoException {
        log.info("start method getBySetDate with dateOfCourse " + dateOfCourse);
        Date date = getFormatDate(dateOfCourse);
        List<Group> groupList = groupDaoInterface.getBySetDate(date);
        return groupList;
    }

    /**
     * This method formats the received date form getBySetDate method.
     *
     * @param date
     * @return
     */
    private Date getFormatDate(String date) {
        log.info("Start method getFormatDate with parameters : " + date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d,yyyy", Locale.ENGLISH);
        LocalDate startLocalDate = LocalDate.parse(date, formatter);
        return Date.valueOf(startLocalDate);
    }

    @Override
    public List<Group> getGroupOnLastQuarter() throws DaoException {
        log.info("start method getReportOnLastQuarter");
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int quarterNumber = getQuarterNumber();
        if (quarterNumber == 1) {
            quarterNumber = 4;
            year = today.getYear() - 1;
        } else if (quarterNumber == 2) {
            quarterNumber = 1;
        } else if (quarterNumber == 3) {
            quarterNumber = 2;
        } else if (quarterNumber == 4) {
            quarterNumber = 3;
        }
        List<Group> groupList = groupDaoInterface.getGroupOnLastQuarter(quarterNumber, year);
        return groupList;
    }

    @Override
    public List<Group> getGroupByTime(String time) throws DaoException {
        log.info("start method getGroupByTime with parameter " + time);
        Time timePeriod = Time.valueOf(time);
        List<Group> groupList = groupDaoInterface.getGroupByTime(timePeriod);
        return groupList;
    }

    @Override
    public List<Group> getGroupByTeacher(Long id) throws DaoException {
        log.info("start method getGroupByTeacher with id " + id);
        List<Group> groupList = groupDaoInterface.getGroupByTeacher(id);
        return groupList;
    }

    @Override
    public void deleteById(Serializable id) {
        log.info("start method deleteById with id " + id);
        try {
            groupDaoInterface.deleteById(id);
        } catch (DaoException e) {
            log.error(e.getMessage(), e);
        }
    }
}
