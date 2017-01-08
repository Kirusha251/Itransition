package net.ahramionok.service.impl;

import net.ahramionok.model.User;
import net.ahramionok.repository.UserRepository;
import net.ahramionok.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by KIrill on 07.01.2017.
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
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteByIdUser(Integer idUser) {
        userRepository.deleteByIdUser(idUser);
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }
}
