import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Павел on 26.02.2016.
 */
public class ISSTest {
    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();

    private static ISS iss;

    @BeforeClass
    public static void setISS() {
        iss = new ISS();
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
        iss.rotate(iss.rotationSpeed);
        Assert.assertEquals("I'm rotating with speed 0.5\r\n", OUTPUT.toString());
    }

    @Test
    public void ISSShouldWorkCorrect() {
        Planet planet = mock(Planet.class);
        when(planet.getName()).thenReturn("Earth");
        iss.work(planet, iss.yearStart);
        Assert.assertEquals("I'm working on Earth in 1998!\r\n", OUTPUT.toString());
    }

    @Test
    public void nameShouldBeCorrect() {
        Assert.assertEquals("ISS", iss.getName());
    }

    @Test
    public void purposeShouldBeCorrect() {
        iss.getPurpose();
        Assert.assertEquals("Explore space\r\n", OUTPUT.toString());
    }

    @Test
    public void rotationAroundStarShouldBeCorrect() {
        Star star = mock(Star.class);
        when(star.getName()).thenReturn("Sun");
        iss.rotateAroundStar(star);
        Assert.assertEquals("I'm rotating around Sun\r\n", OUTPUT.toString());
    }

}
