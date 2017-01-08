package net.ahramionok.service;

import net.ahramionok.model.User;

import java.util.Collection;

/**
 * Created by KIrill on 07.01.2017.
 */
public interface UserService {
    User findByIdUser(Integer idUser);
    User findByEmail(String email);
    User findByUserName(String userName);
    void save(User user);
    void deleteByIdUser(Integer idUser);
    Collection<User> findAll();

}
