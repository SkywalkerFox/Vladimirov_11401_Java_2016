/**
 * Created by Павел on 12.02.2016.
 */
public class Sun implements Star {
    double mass = 1;
    double radius = 1;
    Planet planet;
    double speed = 1;

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
