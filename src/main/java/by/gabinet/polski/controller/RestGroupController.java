package by.gabinet.polski.controller;

import by.gabinet.polski.entity.Group;
import by.gabinet.polski.service.GroupServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.*;

/**
 * Created by Александр Горшов on 23.08.2017  11:35.
 */
@Controller
public class RestGroupController {
    private static Logger log = Logger.getLogger(RestGroupController.class);

    @Autowired
    private GroupServiceInterface groupServiceInterface;

    @GetMapping(value = "/groups/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Group>> getGroupsByCourse(@PathVariable("courseId") Long id) {
        List<Group> groupList = groupServiceInterface.getGroupByCourseId(id);
        return new ResponseEntity<List<Group>>(groupList, HttpStatus.OK);
    }
}
