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
        System.out.println("I'm pulling " + planet.getName() + " <3");
    }

    @Override
    public String getName() {
        return "Sirius";
    }
}
