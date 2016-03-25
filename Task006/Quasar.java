/**
 * Created by Павел on 12.02.2016.
 */
public class Quasar implements Star, Comet {


    @Override
    public void shine() {

    }

    @Override
    public boolean collapseToBlackHole() {
        return false;
    }

    @Override
    public void move(double speed, Star star) {

    }

    @Override
    public void pullSpaceObject(Planet planet) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void rotate() {

    }

    @Override
    public void crash() {
        System.out.println("I'm big and strong, I'm eating other stars, I can't crash!");
    }

    @Override
    public void move() {

    }
}
