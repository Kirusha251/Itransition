package net.ahramionok.service;

import net.ahramionok.model.User;

import java.util.Collection;

/**
 * Created by Kirill on 07.12.2016.
 */

public interface UserService {
    User findByIdUser(Integer idUser);
    User findByUsername(String username);
    User findByEmail(String email);
    void save(User user);
    Collection<User> findAll();
}
