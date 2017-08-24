package by.gabinet.polski.controller;

import by.gabinet.polski.dao.exception.DaoException;
import by.gabinet.polski.entity.Course;
import by.gabinet.polski.entity.Group;
import by.gabinet.polski.entity.User;
import by.gabinet.polski.entity.enumiration.Courses;
import by.gabinet.polski.service.BaseServiceInterface;
import by.gabinet.polski.service.CourseServiceInterface;
import by.gabinet.polski.service.GroupServiceInterface;
import by.gabinet.polski.service.UserServiceInterface;
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
 * Created by Александр Горшов on 31.07.2017  10:36.
 */
@Controller
public class RootController {

    private static Logger log = Logger.getLogger(RootController.class);

    @Autowired
    private UserServiceInterface userServiceInterface;

    @Autowired
    private CourseServiceInterface courseServiceInterface;

    @Autowired
    private GroupServiceInterface groupServiceInterface;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) throws DaoException {
        log.info("start controller method index ");
        List<Course> courseList = courseServiceInterface.getAll(Course.class);
        List<Group> groupList = groupServiceInterface.getAll(Group.class);
        List<Courses> allCourses = getCourses();
        model.addAttribute("mapOfPolish", Courses.MAP_POLES);
        model.addAttribute("fromZeroToA2", Courses.FROM_ZERO_TO_A2);
        model.addAttribute("fromA1A2ToB2", Courses.FROM_A1_A2_TO_B2);
        model.addAttribute("fromB2ToC1", Courses.FROM_B2_TO_C1);
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/after", method = RequestMethod.GET)
    public String afterAuth(Model model) throws DaoException {
        model.addAttribute("user", userServiceInterface.getAll(User.class));
        return "root";
    }

    private List<Courses> getCourses() {
        return new ArrayList<>(EnumSet.allOf(Courses.class));
    }

}
