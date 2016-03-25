package ru.kpfu.itis.pavelvladimirov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ����� on 12.02.2016.
 */
@Component
public class Mars implements Planet {
    @Autowired
    @Qualifier("sun")
    Star STAR;

    @Value("24")
    double ROTATION_SPEED;

    @Value("1")
    int YEAR;

    @Value("0.1")
    double MASS;

    @Override
    public void rotate(double speed) {
        speed = this.ROTATION_SPEED;
        System.out.println("I'm rotating with speed " + speed);
    }

    @Override
    public String getName() {
        return "Mars";
    }

    @Override
    public void rotateAroundStar(Star star) {
        star = this.STAR;
        System.out.println("I'm rotating around " + star.getName());
    }

}
