package net.ahramionok.service.impl;

import net.ahramionok.model.User;
import net.ahramionok.repository.UserRepository;
import net.ahramionok.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Kirill on 07.12.2016.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByIdUser(Integer idUser) {
        return userRepository.findByIdUser(idUser);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }


    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }
}
