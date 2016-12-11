package net.ahramionok.controller;

import net.ahramionok.model.User;
import net.ahramionok.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by Kirill on 07.12.2016.
 */

@RestController
public class UserController {


    @Autowired
    private UserService userService;
    @RequestMapping(value = "/user/id")
    public User findByIdUser(@PathVariable String idUser){
        return userService.findByIdUser(Integer.valueOf(idUser));
    }

    @RequestMapping(value = "/user/username")
    public User findByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }

    @RequestMapping(value = "/user/email")
    public User findByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }
    @RequestMapping(value = "/user/all")
    public Collection<User> findAll(){
        return userService.findAll();
    }


}
