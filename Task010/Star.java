/**
 * Created by Павел on 12.02.2016.
 */
public interface Star {

    void shine();

    boolean collapseToBlackHole();

    void move(double speed, Star star);

    void pullSpaceObject(Planet planet);

    String getName();
}
