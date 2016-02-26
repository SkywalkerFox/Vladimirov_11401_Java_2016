package Task002;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Павел on 23.02.2016.
 */
public class Matrix2x2Test {

    private static Matrix2x2 defaultMatrix;
    private static Matrix2x2 matrix1;
    private static Matrix2x2 matrix4;
    private static final double EPS = 1e-9;

    @Before
    public void matrixCreation() {
        defaultMatrix = new Matrix2x2();
        matrix1 = new Matrix2x2(1);
        matrix4 = new Matrix2x2(1, 2, 3, 4);
    }

    @Test
    public void getterShouldWorkCorrect() {
        Assert.assertEquals(4, matrix4.getA(1, 1), EPS);
    }

    @Test
    public void defaultMatrixShouldBeNull() {
        Assert.assertTrue(defaultMatrix.getA(0, 0) == 0 && defaultMatrix.getA(0, 1) == 0 && defaultMatrix.getA(1, 0) == 0 && defaultMatrix.getA(1, 1) == 0);
    }

    @Test
    public void constructorOn4ValuesShouldWorkCorrect() {
        Assert.assertTrue(matrix4.getA(0, 0) == 1 && matrix4.getA(0, 1) == 2 && matrix4.getA(1, 0) == 3 && matrix4.getA(1, 1) == 4);
    }

    @Test
    public void constructorOnOneValueShouldWorkCorrect() {
        Assert.assertTrue(matrix1.getA(0, 0) == 1 && matrix1.getA(0, 1) == 1 && matrix1.getA(1, 0) == 1 && matrix1.getA(1, 1) == 1);
    }

    @Test
    public void constructorOnArrayShouldWorkCorrect() {
        double[][] array = new double[2][2];
        array[0][0] = 5;
        array[0][1] = 6;
        array[1][0] = 7;
        array[1][1] = 8;
        Matrix2x2 matrix2x2 = new Matrix2x2(array);
        Assert.assertTrue(matrix2x2.getA(0, 0) == 5 && matrix2x2.getA(0, 1) == 6 && matrix2x2.getA(1, 0) == 7 && matrix2x2.getA(1, 1) == 8);
    }

    @Test
    public void additionWithReturnShouldWorkCorrect() {
        Matrix2x2 sum = matrix1.add(matrix4);
        Assert.assertTrue(sum.getA(0, 0) == 2 && sum.getA(0, 1) == 3 && sum.getA(1, 0) == 4 && sum.getA(1, 1) == 5);
    }

    public void additionShouldWorkCorrect() {
        matrix1.add2(matrix4);
        Assert.assertTrue(matrix1.getA(0, 0) == 2 && matrix1.getA(0, 1) == 3 && matrix1.getA(1, 0) == 4 && matrix1.getA(1, 1) == 5);
    }

    @Test
    public void subtractionWithReturnShouldWorkCorrect() {
        Matrix2x2 result = matrix4.sub(matrix1);
        Assert.assertTrue(result.getA(0, 0) == 0 && result.getA(0, 1) == 1 && result.getA(1, 0) == 2 && result.getA(1, 1) == 3);
    }

    @Test
    public void subtractionShouldWorkCorrect() {
        matrix4.sub2(matrix1);
        Assert.assertTrue(matrix4.getA(0, 0) == 0 && matrix4.getA(0, 1) == 1 && matrix4.getA(1, 0) == 2 && matrix4.getA(1, 1) == 3);
    }

    @Test
    public void multiplicationByNumberWithReturnShouldWorkCorrect() {
        Matrix2x2 result = matrix4.multNumber(2);
        Assert.assertTrue(result.getA(0, 0) == 2 && result.getA(0, 1) == 4 && result.getA(1, 0) == 6 && result.getA(1, 1) == 8);
    }

    @Test
    public void multiplicationByNumberShouldWorkCorrect() {
        matrix4.multNumber2(2);
        Assert.assertTrue(matrix4.getA(0, 0) == 2 && matrix4.getA(0, 1) == 4 && matrix4.getA(1, 0) == 6 && matrix4.getA(1, 1) == 8);
    }

    @Test
    public void multiplicationByMatrixWithReturnShouldWorkCorrect() {
        Matrix2x2 result = matrix4.mult(matrix1);
        Assert.assertTrue(result.getA(0, 0) == 3 && result.getA(0, 1) == 3 && result.getA(1, 0) == 7 && result.getA(1, 1) == 7);
    }

    @Test
    public void multiplicationByMatrixShouldWorkCorrect() {
        matrix4.mult2(matrix1);
        Assert.assertTrue(matrix4.getA(0, 0) == 3 && matrix4.getA(0, 1) == 3 && matrix4.getA(1, 0) == 7 && matrix4.getA(1, 1) == 7);
    }

    @Test
    public void determinantShouldBeCorrect() {
        Assert.assertEquals(-2, matrix4.det(), EPS);
    }

    @Test
    public void transpositionShouldWorkCorrect() {
        matrix4.transpon();
        Assert.assertTrue(matrix4.getA(0, 0) == 1 && matrix4.getA(0, 1) == 3 && matrix4.getA(1, 0) == 2 && matrix4.getA(1, 1) == 4);
    }

    @Test
    public void inversionShouldWorkCorrect() {
        Matrix2x2 result = matrix4.inverseMatrix();
        Assert.assertTrue(result.getA(0, 0) == -2 && result.getA(0, 1) == 1 && result.getA(1, 0) == 1.5 && result.getA(1, 1) == -0.5);
    }

    @Test
    public void equivalentDiagonalMatrixShouldBeCorrect() {
        Matrix2x2 result = matrix4.equivalentMatrix();
        Assert.assertTrue(result.getA(0, 0) == -0.33333333333333337 && result.getA(0, 1) == 0 && result.getA(1, 0) == 0 && result.getA(1, 1) == -0.6666666666666667);
    }

    @Test
    public void multiplicationByVectorShouldWorkCorrect() {
        Vector2D vector2D = new Vector2D(1, 2);
        Vector2D result = matrix4.multVector(vector2D);
        Assert.assertTrue(result.getX() == 5 && result.getY() == 11);
    }

    @Test
    public void castToStringShouldWorkCorrect() {
        String result = matrix1.toString();
        Assert.assertEquals("1.0 1.0\n1.0 1.0", result);
    }
}
