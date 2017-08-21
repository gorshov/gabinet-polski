package by.gabinet.polski.service.impl;

import by.gabinet.polski.dao.CompanyDaoInterface;
import by.gabinet.polski.entity.Company;
import by.gabinet.polski.service.CompanyServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Александр Горшов on 14.08.2017  16:31.
 */
@Service
@Transactional
public class CompanyService extends BaseService<Company> implements CompanyServiceInterface<Company> {
    private static Logger log = Logger.getLogger(CompanyService.class);

    @Autowired
    @Qualifier("companyDao")
    private CompanyDaoInterface companyDaoInterface;

}
