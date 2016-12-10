package net.ahramionok.repository;

import net.ahramionok.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Kirill on 07.12.2016.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByIdUser(Integer idUser);
    User findByUsername(String username);
    User findByEmail(String email);
}
