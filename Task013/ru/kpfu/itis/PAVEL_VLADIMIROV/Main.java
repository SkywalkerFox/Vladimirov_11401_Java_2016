package ru.kpfu.itis.PAVEL_VLADIMIROV;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.PAVEL_VLADIMIROV.models.User;

/**
 * Created by Павел on 24.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        User user = ac.getBean(User.class);

        user.setEmail("pasha");
        user.setEmail("pasha96@mail.ru");
    }
}
