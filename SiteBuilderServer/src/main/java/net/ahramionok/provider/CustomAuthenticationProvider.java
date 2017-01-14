package net.ahramionok.provider;

import net.ahramionok.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by KIrill on 14.01.2017.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

    @Autowired
    private UserService userService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        if(userService.findByUserName(name).getUserName().equals(name)&& userService.findByUserName(name).getPassword().equals(password)){
            return  new UsernamePasswordAuthenticationToken(name,password,new ArrayList<>());
        }
        else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
