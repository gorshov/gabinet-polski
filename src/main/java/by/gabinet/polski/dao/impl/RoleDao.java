package by.gabinet.polski.dao.impl;

import by.gabinet.polski.dao.RoleDaoInterface;
import by.gabinet.polski.entity.Role;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Александр Горшов on 11.08.2017  10:54.
 */
@Repository
public class RoleDao extends BaseDao<Role> implements RoleDaoInterface<Role> {
    private static Logger log = Logger.getLogger(RoleDao.class);

    @Autowired
    public RoleDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
