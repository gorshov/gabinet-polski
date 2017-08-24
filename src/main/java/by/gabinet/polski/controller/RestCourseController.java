package by.gabinet.polski.controller;

import by.gabinet.polski.entity.Course;
import by.gabinet.polski.service.CourseServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

/**
 * Created by Александр Горшов on 21.08.2017  23:20.
 */
@RestController
public class RestCourseController {
    private static final Logger log = Logger.getLogger(RestCourseController.class);

    @Autowired
    private CourseServiceInterface courseServiceInterface;

    @GetMapping(value = "/courses/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> findCourseByName(@PathVariable("name") String nameCourse) {
        Course course = courseServiceInterface.getCourseByName(nameCourse);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }
}
