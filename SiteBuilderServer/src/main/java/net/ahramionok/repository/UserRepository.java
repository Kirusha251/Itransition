package net.ahramionok.repository;

import net.ahramionok.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by KIrill on 07.01.2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByIdUser(Integer idUser);
    User findByEmail(String email);
    User findByUserName(String userName);

    @Transactional
    void deleteByIdUser(Integer idUser);
}
