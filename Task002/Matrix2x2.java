package Task002;

/**
 * Created by Павел on 23.02.2016.
 */
public class Matrix2x2 {
    private double[][] a = new double[2][2];

    public double getA(int i, int j) {
        return this.a[i][j];
    }

    public Matrix2x2() {
        for(int i = 0; i < 2; ++i) {
            for(int j = 0; j < 2; ++j) {
                this.a[i][j] = 0.0D;
            }
        }

    }

    public Matrix2x2(double x) {
        for(int i = 0; i < 2; ++i) {
            for(int j = 0; j < 2; ++j) {
                this.a[i][j] = x;
            }
        }

    }

    public Matrix2x2(double[][] a) {
        for(int i = 0; i < 2; ++i) {
            for(int j = 0; j < 2; ++j) {
                this.a[i][j] = a[i][j];
            }
        }

    }

    public Matrix2x2(double x, double y, double z, double w) {
        this.a[0][0] = x;
        this.a[0][1] = y;
        this.a[1][0] = z;
        this.a[1][1] = w;
    }

    public Matrix2x2 add(Matrix2x2 b) {
        Matrix2x2 matrix2x2_sum = new Matrix2x2(this.a[0][0] + b.getA(0, 0), this.a[0][1] + b.getA(0, 1), this.a[1][0] + b.getA(1, 0), this.a[1][1] + b.getA(1, 1));
        return matrix2x2_sum;
    }

    public void add2(Matrix2x2 b) {
        this.a[0][0] += b.getA(0, 0);
        this.a[0][1] += b.getA(0, 1);
        this.a[1][0] += b.getA(1, 0);
        this.a[1][1] += b.getA(1, 1);
        System.out.println(this.toString());
    }

    public Matrix2x2 sub(Matrix2x2 b) {
        Matrix2x2 matrix2x2_sub = new Matrix2x2(this.a[0][0] - b.getA(0, 0), this.a[0][1] - b.getA(0, 1), this.a[1][0] - b.getA(1, 0), this.a[1][1] - b.getA(1, 1));
        return matrix2x2_sub;
    }

    public void sub2(Matrix2x2 b) {
        this.a[0][0] -= b.getA(0, 0);
        this.a[0][1] -= b.getA(0, 1);
        this.a[1][0] -= b.getA(1, 0);
        this.a[1][1] -= b.getA(1, 1);
        System.out.println(this.toString());
    }

    public Matrix2x2 multNumber(double x) {
        Matrix2x2 matrix2x2_mn = new Matrix2x2(this.a[0][0] * x, this.a[0][1] * x, this.a[1][0] * x, this.a[1][1] * x);
        return matrix2x2_mn;
    }

    public void multNumber2(double x) {
        this.a[0][0] *= x;
        this.a[0][1] *= x;
        this.a[1][0] *= x;
        this.a[1][1] *= x;
        System.out.println(this.toString());
    }

    public Matrix2x2 mult(Matrix2x2 b) {
        double c1 = this.a[0][0] * b.getA(0, 0) + this.a[0][1] * b.getA(1, 0);
        double c2 = this.a[0][0] * b.getA(0, 1) + this.a[0][1] * b.getA(1, 1);
        double c3 = this.a[1][0] * b.getA(0, 0) + this.a[1][1] * b.getA(1, 0);
        double c4 = this.a[1][0] * b.getA(0, 1) + this.a[1][1] * b.getA(1, 1);
        Matrix2x2 matrix2x2_mult = new Matrix2x2(c1, c2, c3, c4);
        return matrix2x2_mult;
    }

    public void mult2(Matrix2x2 b) {
        double c1 = this.a[0][0];
        double c2 = this.a[0][1];
        double c3 = this.a[1][0];
        double c4 = this.a[1][1];
        this.a[0][0] = c1 * b.getA(0, 0) + c2 * b.getA(1, 0);
        this.a[0][1] = c1 * b.getA(0, 1) + c2 * b.getA(1, 1);
        this.a[1][0] = c3 * b.getA(0, 0) + c4 * b.getA(1, 0);
        this.a[1][1] = c3 * b.getA(0, 1) + c4 * b.getA(1, 1);
        System.out.println(this.toString());
    }

    public double det() {
        return this.a[0][0] * this.a[1][1] - this.a[0][1] * this.a[1][0];
    }

    public void transpon() {
        this.a[1][0] += this.a[0][1];
        this.a[0][1] = this.a[1][0] - this.a[0][1];
        this.a[1][0] -= this.a[0][1];
    }

    public Matrix2x2 inverseMatrix() {
        Matrix2x2 zero = new Matrix2x2();
        if(this.det() == 0.0D) {
            return zero;
        } else {
            this.a[0][0] += this.a[1][1];
            this.a[1][1] = this.a[0][0] - this.a[1][1];
            this.a[0][0] -= this.a[1][1];
            this.a[0][1] = -this.a[0][1];
            this.a[1][0] = -this.a[1][0];
            return this.multNumber(1.0D / this.det());
        }
    }

    public Matrix2x2 equivalentMatrix() {
        this.a[1][1] = this.a[0][0] / this.a[1][0] * this.a[1][1] - this.a[0][1];
        this.a[1][0] = 0.0D;
        this.a[0][0] = this.a[1][1] / this.a[0][1];
        this.a[0][1] = 0.0D;
        return this;
    }

    public Vector2D multVector(Vector2D v) {
        double c1 = this.a[0][0] * v.getX() + this.a[0][1] * v.getY();
        double c2 = this.a[1][0] * v.getX() + this.a[1][1] * v.getY();
        Vector2D v_new = new Vector2D(c1, c2);
        return v_new;
    }

    public String toString() {
        return this.a[0][0] + " " + this.a[0][1] + "\n" + this.a[1][0] + " " + this.a[1][1];
    }
}
