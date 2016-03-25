import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ����� on 26.02.2016.
 */
public class QuasarTest {
    private static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");

    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();

    private static Quasar quasar;

    @BeforeClass
    public static void setQuasar() {
        quasar = (Quasar) ac.getBean("quasar");
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
    public void shiningShouldBeCorrect() {
        quasar.shine();
        Assert.assertEquals("", OUTPUT.toString());
    }

    @Test
    public void collapsingShouldBeCorrect() {
        Assert.assertFalse(quasar.collapseToBlackHole());
    }

    @Test
    public void movingToTheStarShouldBeCorrect() {
        Star star = mock(Star.class);
        when(star.getName()).thenReturn("Sun");
        quasar.move(10, star);
        Assert.assertEquals("", OUTPUT.toString());
    }

    @Test
    public void pullingSpaceObjectShouldBeCorrect() {
        Planet planet = mock(Planet.class);
        when(planet.getName()).thenReturn("Mars");
        quasar.pullSpaceObject(planet);
        Assert.assertEquals("", OUTPUT.toString());
    }

    @Test
    public void nameShouldBeCorrect() {
        Assert.assertEquals(null, quasar.getName());
    }

    @Test
    public void rotationShoulfBeCorrect() {
        quasar.rotate();
        Assert.assertEquals("", OUTPUT.toString());
    }

    @Test
    public void crashingShouldBeCorrect() {
        quasar.crash();
        Assert.assertEquals("I'm big and strong, I'm eating other stars, I can't crash!\r\n", OUTPUT.toString());
    }

    @Test
    public void movingShouldBeCorrect() {
        quasar.move();
        Assert.assertEquals("", OUTPUT.toString());
    }
}
