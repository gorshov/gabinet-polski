package by.gabinet.polski.controller;

import by.gabinet.polski.service.BaseServiceInterface;
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
    private BaseServiceInterface serviceInterface;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "root.jsp";
    }

}