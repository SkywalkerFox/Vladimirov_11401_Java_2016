import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Павел on 25.02.2016.
 */
public class EarthTest {

    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();

    private static Earth earth;

    @BeforeClass
    public static void setEarth() {
        earth = new Earth();
    }

    @Before
    public void setOUTPUT() {
        System.setOut(new PrintStream(OUTPUT));
    }

    @After
    public void clearOUTPUT() {
        System.setOut(null);
    }

    @Test
    public void rotationShouldBeCorrect() {
        earth.rotate(earth.rotationSpeed);
        Assert.assertEquals("I'm rotating with speed 24.0\r\n", OUTPUT.toString());
    }

    @Test
    public void nameShouldBeCorrect() {
        Assert.assertEquals("Earth", earth.getName());
    }

    @Test
    public void rotationAroundStarShouldBeCorrect() {
        Star star = mock(Star.class);
        when(star.getName()).thenReturn("Sun");
        earth.rotateAroundStar(star);
        Assert.assertEquals("I'm rotating around Sun\r\n", OUTPUT.toString());
    }

    @Test
    public void doingSomethingShouldWorkCorrect() {
        earth.doSmth();
        Assert.assertEquals("do something\r\n", OUTPUT.toString());
    }
}
