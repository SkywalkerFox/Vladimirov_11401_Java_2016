package ru.kpfu.itis.pavelvladimirov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Павел on 21.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");

        Curiosity curiosity = (Curiosity) ac.getBean("curiosity");
        Earth earth = (Earth) ac.getBean("earth");
        Sun sun = (Sun) ac.getBean("sun");
        ISS iss = (ISS) ac.getBean("iss");
        Mars mars = (Mars) ac.getBean("mars");
        Quasar quasar = (Quasar) ac.getBean("quasar");
        Sirius sirius = (Sirius) ac.getBean("sirius");
        Voyager voyager = (Voyager) ac.getBean("voyager");

        curiosity.getName();
        curiosity.getPurpose();
        curiosity.work(earth, 2000);

        earth.getName();
        earth.doSmth();
        earth.rotate(10);
        earth.rotateAroundStar(sun);

        iss.getPurpose();
        iss.rotateAroundStar(sun);
        iss.rotate(1);
        iss.work(earth, 1998);
        iss.getName();

        mars.getName();
        mars.rotate(10);
        mars.rotateAroundStar(sun);

        quasar.getName();
        quasar.collapseToBlackHole();
        quasar.crash();
        quasar.move();
        quasar.move(10, sun);
        quasar.pullSpaceObject(mars);
        quasar.rotate();
        quasar.shine();

        sirius.shine();
        sirius.pullSpaceObject(mars);
        sirius.move(10, sun);
        sirius.collapseToBlackHole();
        sirius.getName();

        sun.shine();
        sun.pullSpaceObject(mars);
        sun.move(10, sirius);
        sun.collapseToBlackHole();
        sun.getName();

    }
}
