package ru.kpfu.itis.pavelvladimirov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ����� on 12.02.2016.
 */
@Component
public class Curiosity implements Spacecraft {
    @Value("10")
    double speed;

    @Autowired
    @Qualifier("earth")
    Planet start;

    @Value("0.001")
    double mass;

    @Value("2012")
    int yearStart;

    @Override
    public void work(Planet planet, int year) {
        planet = start;
        year = this.yearStart;
        System.out.println("I'm working on " + planet.getName() + " in " + year + "!");
    }

    @Override
    public String getName() {
        return "Curiosity";
    }

    @Override
    public void getPurpose() {
        System.out.println("Study, study and study again!");
    }
}
