package by.gabinet.polski.controller;

import by.gabinet.polski.entity.User;
import by.gabinet.polski.service.BaseServiceInterface;
import by.gabinet.polski.service.UserServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Александр Горшов on 31.07.2017  10:36.
 */
@Controller
public class RootController {

    private static Logger log = Logger.getLogger(RootController.class);

    @Autowired
    private UserServiceInterface userServiceInterface;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/after", method = RequestMethod.GET)
    public String afterAuth(Model model) {
        model.addAttribute("user", userServiceInterface.getAll(User.class));
        return "root";
    }


}
