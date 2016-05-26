package ru.kpfu.itis.PAVEL_VLADIMIROV.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.PAVEL_VLADIMIROV.entity.User;
import ru.kpfu.itis.PAVEL_VLADIMIROV.repository.UserRepository;

import java.util.List;

/**
 * Created by Павел on 24.04.2016.
 */
@Service
@ComponentScan("ru.kpfu.itis.PAVEL_VLADIMIROV.repository")
public class UserServiceImpl implements UserService {
    @Qualifier("userRepository")
    @Autowired
    public UserRepository userRepository;

    @Transactional
    public void addUser(User user) {
        userRepository.save(user);

    }

    @Transactional
    public void delete(long id) {

    }

    @Transactional
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public void editUser(User user) {
        
    }

    @Transactional
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.getById(id);
    }
}
