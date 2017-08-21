package by.gabinet.polski.controller;

import by.gabinet.polski.dao.exception.DaoException;
import by.gabinet.polski.entity.Group;
import by.gabinet.polski.entity.enumiration.Courses;
import by.gabinet.polski.service.GroupServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by Александр Горшов on 17.08.2017  23:09.
 */
@Controller
public class GroupController {
    private static Logger log = Logger.getLogger(GroupController.class);

    @Autowired
    private GroupServiceInterface groupServiceInterface;

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public String ShowGroupByCourses(Model model) throws DaoException {
        log.info("start method ShowGroupByCourses");
        List<Group> groupList = groupServiceInterface.getAll(Group.class);
        model.addAttribute("groupList", groupList);
        return "index";
    }

    private List<Courses> getCourses() {
        return new ArrayList<>(EnumSet.allOf(Courses.class));
    }
}
