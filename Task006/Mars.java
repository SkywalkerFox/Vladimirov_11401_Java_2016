/**
 * Created by ����� on 12.02.2016.
 */
public class Mars implements Planet {
    final Star STAR = new Sun();
    final double ROTATION_SPEED = 24;
    final int YEAR = 1;
    final double MASS = 0.1;

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
