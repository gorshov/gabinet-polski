package by.gabinet.polski.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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

    @Test
    public void saveOrUpdateTest(){



    }

}
