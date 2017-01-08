package net.ahramionok.controller;

import net.ahramionok.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by KIrill on 07.01.2017.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
}
