package ru.kpfu.itis.PAVEL_VLADIMIROV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.User;

/**
 * Created by Павел on 24.04.2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User getById(Integer id);
}
