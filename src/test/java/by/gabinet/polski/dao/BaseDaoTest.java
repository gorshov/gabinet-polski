package by.gabinet.polski.dao;

import by.gabinet.polski.dao.exception.DaoException;
import by.gabinet.polski.dao.impl.GroupDao;
import by.gabinet.polski.entity.Group;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

/**
 * Created by Александр Горшов on 28.07.2017  14:44.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:root-config.xml", "classpath:bean-db.xml"})
@Commit
@Transactional(transactionManager = "txManager")
public class BaseDaoTest {

    @Autowired
    private BaseDaoInterface baseDaoInterface;

    @Autowired
    private GroupDaoInterface groupDaoInterface;

    @Test
    public void saveOrUpdateTest() {


    }

    @Test
    public void getGroupByCurrentQuarterTest() {

    }

    @Test
    public void getBySetDateTest() throws DaoException {
        String startDate = "2017-06-30";
        Date dateStart = Date.valueOf(startDate);
        String endDate = "2017-08-30";
        Date dateEnd = Date.valueOf(endDate);
        List<Group> groupList = groupDaoInterface.getBySetDate(dateStart);
        int size = groupList.size();
    }


}
