package ru.kpfu.itis.pavelvladimirov;

/**
 * Created by ����� on 12.02.2016.
 */
public interface Star {

    void shine();

    boolean collapseToBlackHole();

    void move(double speed, Star star);

    void pullSpaceObject(Planet planet);

    String getName();
}
