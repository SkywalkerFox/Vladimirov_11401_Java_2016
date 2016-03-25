package ru.kpfu.itis.pavelvladimirov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ����� on 12.02.2016.
 */
@Component
public class Earth implements Planet {
    @Autowired
    @Qualifier("sun")
    Star star;

    @Value("24")
    double rotationSpeed;

    @Value("0")
    int yearOfOpening;

    @Value("1")
    double mass;

    @Override
    public void rotate(double speed) {
        speed = this.rotationSpeed;
        System.out.println("I'm rotating with speed " + speed);
    }

    @Override
    public String getName() {
        return "Earth";
    }

    @Override
    public void rotateAroundStar(Star star) {
        star = this.star;
        System.out.println("I'm rotating around " + star.getName());
    }


    public void doSmth() {
        System.out.println("do something");
    }


}
