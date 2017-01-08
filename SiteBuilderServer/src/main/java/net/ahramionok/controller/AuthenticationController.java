package net.ahramionok.controller;

import net.ahramionok.model.Authentication;
import net.ahramionok.model.User;
import net.ahramionok.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by KIrill on 07.01.2017.
 */
@RestController
public class AuthenticationController {

    @Autowired
    private UserService userService;
    @CrossOrigin
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Authentication Authentication(@RequestBody Authentication authentication){
        System.out.println(authentication.getEmail() + authentication.getPassword());
        if(userService.findByEmail(authentication.getEmail()).getPassword().equals(authentication.getPassword())) {
            return new Authentication(authentication.getEmail(),authentication.getPassword(),true);
        }
        else{
            return new Authentication(authentication.getEmail(),authentication.getPassword(),false);
        }
    }
}
