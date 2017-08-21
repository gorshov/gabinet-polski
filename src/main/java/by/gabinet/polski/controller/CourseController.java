package by.gabinet.polski.controller;

import by.gabinet.polski.service.CourseServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Александр Горшов on 20.08.2017  23:14.
 */
@Controller
public class CourseController {
    private static Logger log = Logger.getLogger(CourseController.class);

    @Autowired
    private CourseServiceInterface courseServiceInterface;
}
