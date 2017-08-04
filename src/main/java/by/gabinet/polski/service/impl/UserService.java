package by.gabinet.polski.service.impl;

import by.gabinet.polski.dao.BaseDaoInterface;
import by.gabinet.polski.dao.UserDaoInterface;
import by.gabinet.polski.entity.User;
import by.gabinet.polski.service.UserServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Александр Горшов on 03.08.2017  20:04.
 */
@Service
@Transactional
public class UserService extends BaseService<User> implements UserServiceInterface<User> {
    private static Logger log = Logger.getLogger(UserService.class);

    @Autowired
    @Qualifier("userDao")
    private UserDaoInterface userDaoInterface;

    @Override
    public User findByLogin(String login) {
        log.info("start service method findBylogin with param " + login);
        return userDaoInterface.findByLogin(login);
    }
}
