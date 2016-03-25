/**
 * Created by ����� on 12.02.2016.
 */
public class Earth implements Planet {
    Star star = new Sun();
    double rotationSpeed = 24;
    int yearOfOpening = 0;
    double mass = 1;

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
