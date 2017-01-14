package net.ahramionok.controller;

import com.sun.deploy.net.HttpResponse;
import net.ahramionok.model.Authentication;
import net.ahramionok.model.User;
import net.ahramionok.security.SecurityConfiguration;
import net.ahramionok.service.UserService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by KIrill on 07.01.2017.
 */
@RestController
public class AuthenticationController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @CrossOrigin
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public int Authentication(@RequestBody Authentication authentication, BindingResult result, HttpServletRequest request, HttpServletResponse response){

        System.out.println(authentication.getEmail() + authentication.getPassword());
        if(userService.findByEmail(authentication.getEmail()).getPassword().equals(authentication.getPassword())) {

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authentication.getEmail(), authentication.getPassword());
            request.getSession();
            token.setDetails(new WebAuthenticationDetails(request));
            org.springframework.security.core.Authentication authenticatedUser = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
            System.out.println("kaef");
            return Response.SC_OK;
        }
        else{
            System.out.println("ne kaef");
            return Response.SC_FORBIDDEN;
        }


    }
}
