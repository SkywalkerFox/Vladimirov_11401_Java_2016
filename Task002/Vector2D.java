package Task002;

/**
 * Created by Павел on 17.02.2016.
 */
public class Vector2D {

    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(){

    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Vector2D add(Vector2D vector2D) {
        Vector2D addResult = new Vector2D(this.x + vector2D.getX(), this.y + vector2D.getY());
        return addResult;
    }
}
