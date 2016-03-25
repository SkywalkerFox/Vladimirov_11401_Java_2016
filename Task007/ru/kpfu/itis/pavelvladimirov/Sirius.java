package ru.kpfu.itis.pavelvladimirov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ����� on 12.02.2016.
 */
@Component
public class Sirius implements Star {
    @Value("2")
    double mass;

    @Value("1")
    double radius;

    @Autowired
    @Qualifier("mars")
    Planet planet;

    @Value("1")
    double speed;

    @Override
    public void shine() {
        System.out.println("In the starry sky I burn all the brighter");
    }

    @Override
    public boolean collapseToBlackHole() {
        if (this.mass > 10 ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void move(double speed, Star star) {
        System.out.println("I'm just shining, I do not want to move anywhere");
    }

    @Override
    public void pullSpaceObject(Planet planet) {
        planet = this.planet;
        System.out.println("I'm pulling " + planet.getName() + " <3");
    }

    @Override
    public String getName() {
        return "Sirius";
    }
}
