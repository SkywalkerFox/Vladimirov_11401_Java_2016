package ru.kpfu.itis.PAVEL_VLADIMIROV.service;

import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.User;

import java.util.List;

/**
 * Created by Павел on 24.04.2016.
 */

public interface UserService {
    void addUser(User user);
    void delete(long id);
    User getByEmail(String email);
    void editUser(User user);
    List<User> getAll();
    User getById(Integer id);
}
