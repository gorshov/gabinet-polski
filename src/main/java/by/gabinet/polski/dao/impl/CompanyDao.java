package by.gabinet.polski.dao.impl;

import by.gabinet.polski.dao.CompanyDaoInterface;
import by.gabinet.polski.entity.Company;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Александр Горшов on 11.08.2017  10:57.
 */
@Repository
public class CompanyDao extends BaseDao<Company> implements CompanyDaoInterface<Company> {
    private static Logger log = Logger.getLogger(CompanyDao.class);

    @Autowired
    public CompanyDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
