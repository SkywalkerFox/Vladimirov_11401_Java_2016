/**
 * Created by Павел on 12.02.2016.
 */
public class Curiosity implements Spacecraft {
    double speed = 10;
    final Planet START = new Earth();
    double mass = 0.001;
    int yearStart = 2012;


    @Override
    public void work(Planet planet, int year) {
        planet = new Mars();
        year = this.yearStart;
        System.out.println("I'm working on " + planet.getName() + " in " + year + "!");
    }

    @Override
    public String getName() {
        return "Curiosity";
    }

    @Override
    public void getPurpose() {
        System.out.println("Study, study and study again!");
    }
}
