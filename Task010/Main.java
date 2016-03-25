import java.util.ArrayList;

/**
 * Created by ����� on 12.02.2016.
 */
public class Main {
    public static void main(String[] args) {

        Planet earth = new Earth();
        Sun sun = new Sun();
        Sirius sirius = new Sirius();
        ArrayList<Star> stars = new ArrayList<Star>();
        stars.add(sun);
        stars.add(sirius);
        for(Star star : stars) { //�����������
            star.shine();
        }

        sun.pullSpaceObject(earth);
        sun.getName();
        sun.collapseToBlackHole();
        sun.move(100, sirius);
        sirius.getName();
        sirius.move(0, sun);
        sirius.collapseToBlackHole();

        //earth.doSmth(); �� ���������, ���������� ��������������
        Earth earth2 = new Earth();
        earth2.doSmth();
        earth.rotate(100);
        earth.rotateAroundStar(sun);
        earth.getName();






    }
}
