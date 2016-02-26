/**
 * Created by Павел on 12.02.2016.
 */
public class ISS implements Planet, Spacecraft{
    double rotationSpeed = 0.5;
    int yearStart = 1998;
    Star sun = new Sun();
    double mass = 0.001;

    @Override
    public void rotate(double speed) {
        speed = this.rotationSpeed;
        System.out.println("I'm rotating with speed " + speed);
    }

    @Override
    public void work(Planet planet, int year) {
        planet = new Earth();
        year = this.yearStart;
        System.out.println("I'm working on " + planet.getName() + " in " + year + "!");
    }

    @Override
    public String getName() {
        return "ISS";
    }

    @Override
    public void getPurpose() {
        System.out.println("Explore space");
    }

    @Override
    public void rotateAroundStar(Star star) {
        star = this.sun;
        System.out.println("I'm rotating around " + star.getName());
    }
}
