import java.util.ArrayList;

/**
 * Created by Павел on 12.02.2016.
 */
public interface Planet {

    void rotate(double speed);

    String getName();

    void rotateAroundStar(Star star);

    //ArrayList<String> getSatellites();


}
