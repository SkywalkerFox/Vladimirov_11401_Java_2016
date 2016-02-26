import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Павел on 25.02.2016.
 */
public class CuriosityTest {

    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();

    private static Curiosity curiosity;

    @Before
    public void setOUTPUT() {
        System.setOut(new PrintStream(OUTPUT));
    }

    @After
    public void clearOUTPUT() {
        System.setOut(null);
    }

    @BeforeClass
    public static void curiosityCreation() {
        curiosity = new Curiosity();
    }

    @Test
    public void curiosityShouldWorkCorrect() {
        Planet planet = mock(Planet.class);
        when(planet.getName()).thenReturn("Mars");
        curiosity.work(planet, curiosity.yearStart);
        Assert.assertEquals("I'm working on Mars in 2012!\r\n", OUTPUT.toString());
    }

    @Test
    public void purposeShouldBeCorrect() {
        curiosity.getPurpose();
        Assert.assertEquals("Study, study and study again!\r\n", OUTPUT.toString());
    }

    @Test
    public void nameShouldBeCorrect() {
        Assert.assertEquals("Curiosity", curiosity.getName());
    }
}
