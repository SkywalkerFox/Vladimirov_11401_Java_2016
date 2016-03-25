import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kpfu.itis.pavelvladimirov.*;

/**
 * Created by Павел on 21.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);

        Curiosity curiosity = (Curiosity) ac.getBean(Curiosity.class);
        Earth earth = (Earth) ac.getBean(Earth.class);
        Sun sun = (Sun) ac.getBean(Sun.class);
        ISS iss = (ISS) ac.getBean(ISS.class);
        Mars mars = (Mars) ac.getBean(Mars.class);
        Quasar quasar = (Quasar) ac.getBean(Quasar.class);
        Sirius sirius = (Sirius) ac.getBean(Sirius.class);
        Voyager voyager = (Voyager) ac.getBean(Voyager.class);

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

        voyager.getPurpose();
        voyager.work(mars, 2000);
        voyager.getName();

    }
}
