package ru.kpfu.itis.pavelvladimirov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ����� on 12.02.2016.
 */
@Component
public class ISS implements Planet, Spacecraft {
    @Value("0.5")
    double rotationSpeed;

    @Value("1998")
    int yearStart;

    @Autowired
    @Qualifier("sun")
    Star sun = new Sun();

    @Value("0.001")
    double mass;

    @Override
    public void rotate(double speed) {
        speed = this.rotationSpeed;
        System.out.println("I'm rotating with speed " + speed);
    }

    @Override
    public void work(Planet planet, int year) {
        planet = new Earth();
        year = this.yearStart;
        System.out.println("I'm working on " + planet.getName() + " in " + year + "!");
    }

    @Override
    public String getName() {
        return "ISS";
    }

    @Override
    public void getPurpose() {
        System.out.println("Explore space");
    }

    @Override
    public void rotateAroundStar(Star star) {
        star = this.sun;
        System.out.println("I'm rotating around " + star.getName());
    }
}
