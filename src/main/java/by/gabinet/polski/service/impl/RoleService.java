package by.gabinet.polski.service.impl;

import by.gabinet.polski.dao.RoleDaoInterface;
import by.gabinet.polski.entity.Role;
import by.gabinet.polski.service.RoleServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Александр Горшов on 14.08.2017  16:36.
 */
@Service
@Transactional
public class RoleService extends BaseService<Role> implements RoleServiceInterface<Role> {
    private static Logger log = Logger.getLogger(RoleService.class);

    @Autowired
    @Qualifier("roleDao")
    private RoleDaoInterface roleDaoInterface;
}
