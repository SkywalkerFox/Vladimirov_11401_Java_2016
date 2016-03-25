package ru.kpfu.itis.PAVEL_VLADIMIROV;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.PAVEL_VLADIMIROV.models.Executor;

import java.sql.SQLException;

/**
 * Created by Павел on 25.03.2016.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Executor executor = ac.getBean(Executor.class);
        executor.execute("lol");
        executor.execute("select * from news;");

    }
}
