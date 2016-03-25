import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Павел on 21.03.2016.
 */
public class ComplexMatrix2x2Test {

    private static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");

    private static ComplexMatrix2x2 defaultMatrix;
    private static ComplexMatrix2x2 matrix1;
    private static ComplexMatrix2x2 matrix4;

    private static ComplexNumber number1;

    @Before
    public void matrixCreation() {
        defaultMatrix = (ComplexMatrix2x2) ac.getBean("default");
        matrix1 = (ComplexMatrix2x2) ac.getBean("matrix1");
        matrix4 = (ComplexMatrix2x2) ac.getBean("matrix4");
    }

    @BeforeClass
    public static void mocksCreation() {
        number1 = mock(ComplexNumber.class);
        when(number1.getRe()).thenReturn(1.0);
        when(number1.getIm()).thenReturn(1.0);
        when(number1.equals(anyObject())).thenCallRealMethod();

    }

    @Test
    public void getterShouldWorkCorrect() {
        Assert.assertTrue(matrix1.getA(0, 0).equals(number1));
    }

    @Test
    public void defaultMatrixShouldBeNull() {
        ComplexNumber number = mock(ComplexNumber.class);
        when(number.getRe()).thenReturn(0.0);
        when(number.getIm()).thenReturn(0.0);
        when(number.equals(anyObject())).thenCallRealMethod();
        Assert.assertTrue(defaultMatrix.getA(0, 0).equals(number) && defaultMatrix.getA(0, 1).equals(number) &&
                defaultMatrix.getA(1, 0).equals(number) && defaultMatrix.getA(1, 1).equals(number));
    }

    @Test
    public void constructorOnOneValueShouldWorkCorrect() {
        Assert.assertTrue(matrix1.getA(0, 0).equals(number1) && matrix1.getA(0, 1).equals(number1) &&
                matrix1.getA(1, 0).equals(number1) && matrix1.getA(1, 1).equals(number1));
    }

    @Test
    public void constructorOn4ValuesShouldWorkCorrect() {
        ComplexNumber number2 = mock(ComplexNumber.class);
        when(number2.getRe()).thenReturn(2.0);
        when(number2.getIm()).thenReturn(2.0);
        when(number2.equals(anyObject())).thenCallRealMethod();
        ComplexNumber number3 = mock(ComplexNumber.class);
        when(number3.getRe()).thenReturn(3.0);
        when(number3.getIm()).thenReturn(3.0);
        when(number3.equals(anyObject())).thenCallRealMethod();
        ComplexNumber number4 = mock(ComplexNumber.class);
        when(number4.getRe()).thenReturn(4.0);
        when(number4.getIm()).thenReturn(4.0);
        when(number4.equals(anyObject())).thenCallRealMethod();
        Assert.assertTrue(matrix4.getA(0, 0).equals(number1) && matrix4.getA(0, 1).equals(number2) &&
                matrix4.getA(1, 0).equals(number3) && matrix4.getA(1, 1).equals(number4));
    }

    @Test
    public void additionShouldWorkCorrect() {
        ComplexMatrix2x2 result = matrix1.add(matrix4);
        ComplexNumber number1 = mock(ComplexNumber.class);
        when(number1.getRe()).thenReturn(2.0);
        when(number1.getIm()).thenReturn(2.0);
        when(number1.equals(anyObject())).thenCallRealMethod();
        ComplexNumber number2 = mock(ComplexNumber.class);
        when(number2.getRe()).thenReturn(3.0);
        when(number2.getIm()).thenReturn(3.0);
        when(number2.equals(anyObject())).thenCallRealMethod();
        ComplexNumber number3 = mock(ComplexNumber.class);
        when(number3.getRe()).thenReturn(4.0);
        when(number3.getIm()).thenReturn(4.0);
        when(number3.equals(anyObject())).thenCallRealMethod();
        ComplexNumber number4 = mock(ComplexNumber.class);
        when(number4.getRe()).thenReturn(5.0);
        when(number4.getIm()).thenReturn(5.0);
        when(number4.equals(anyObject())).thenCallRealMethod();
        Assert.assertTrue(result.getA(0, 0).equals(number1) && result.getA(0, 1).equals(number2) &&
                result.getA(1, 0).equals(number3) && result.getA(1, 1).equals(number4));

    }

    @Test
    public void multiplicationByMatrixShouldWorkCorrect() {
        ComplexMatrix2x2 result = matrix4.mult(matrix4);
        ComplexNumber number1 = mock(ComplexNumber.class);
        when(number1.getRe()).thenReturn(0.0);
        when(number1.getIm()).thenReturn(14.0);
        when(number1.equals(anyObject())).thenCallRealMethod();
        ComplexNumber number2 = mock(ComplexNumber.class);
        when(number2.getRe()).thenReturn(0.0);
        when(number2.getIm()).thenReturn(20.0);
        when(number2.equals(anyObject())).thenCallRealMethod();
        ComplexNumber number3 = mock(ComplexNumber.class);
        when(number3.getRe()).thenReturn(0.0);
        when(number3.getIm()).thenReturn(30.0);
        when(number3.equals(anyObject())).thenCallRealMethod();
        ComplexNumber number4 = mock(ComplexNumber.class);
        when(number4.getRe()).thenReturn(0.0);
        when(number4.getIm()).thenReturn(44.0);
        when(number4.equals(anyObject())).thenCallRealMethod();
        Assert.assertTrue(result.getA(0, 0).equals(number1) && result.getA(0, 1).equals(number2) &&
                result.getA(1, 0).equals(number3) && result.getA(1, 1).equals(number4));
    }

    @Test
    public void determinantShouldBeCorrect() {
        ComplexNumber number = mock(ComplexNumber.class);
        when(number.getRe()).thenReturn(0.0);
        when(number.getIm()).thenReturn(-4.0);
        when(number.equals(anyObject())).thenCallRealMethod();
        Assert.assertTrue(matrix4.det().equals(number));
    }

    @Test
    public void multiplicationByVectorShouldWorkCorrect() {
        ComplexVector2D vector2D = matrix4.multVector(new ComplexVector2D(new ComplexNumber(1, 1), new ComplexNumber(2, 2)));
        ComplexNumber number1 = mock(ComplexNumber.class);
        when(number1.getRe()).thenReturn(0.0);
        when(number1.getIm()).thenReturn(10.0);
        when(number1.equals(anyObject())).thenCallRealMethod();
        ComplexNumber number2 = mock(ComplexNumber.class);
        when(number2.getRe()).thenReturn(0.0);
        when(number2.getIm()).thenReturn(22.0);
        when(number2.equals(anyObject())).thenCallRealMethod();
        Assert.assertTrue(vector2D.getCn1().equals(number1) && vector2D.getCn2().equals(number2));
    }

    @Test
    public void castToStringShouldWorkCorrect() {
        Assert.assertEquals("1.0 + 1.0 * i 1.0 + 1.0 * i\n1.0 + 1.0 * i 1.0 + 1.0 * i", matrix1.toString());
    }
}
