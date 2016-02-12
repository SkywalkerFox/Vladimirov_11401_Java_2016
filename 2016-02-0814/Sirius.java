/**
 * Created by Павел on 12.02.2016.
 */
public class Sirius implements Star {
    double mass = 2;
    double radius = 1;
    Planet planet;
    double speed = 1;

    @Override
    public void shine() {
        System.out.println("На звездном небе горю ярче всех");
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
        System.out.println("Я просто свечусь,не хочу никуда двигаться");
    }

    @Override
    public void pullSpaceObject(Planet planet) {
        System.out.println("I'm pulling " + planet.getName() + " <3");
    }

    @Override
    public String getName() {
        return "Sirius";
    }
}
