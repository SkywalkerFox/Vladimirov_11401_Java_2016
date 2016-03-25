package ru.kpfu.itis.pavelvladimirov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ����� on 12.02.2016.
 */
@Component
public class Sun implements Star {
    @Value("1")
    double mass;

    @Value("1")
    double radius;

    @Autowired
    @Qualifier("earth")
    Planet planet;

    @Value("1")
    double speed;

    @Override
    public void shine() {
        System.out.println("I'm burning bright, sparking well, creating life");
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
        System.out.println("I'm moving to " + star.getName() + " with speed = " + speed + ". VERY FAST!!!");
    }

    @Override
    public void pullSpaceObject(Planet planet) {
        System.out.println("I'm pulling " + planet.getName() + " <3");
    }

    @Override
    public String getName() {
        return "Sun";
    }
}
