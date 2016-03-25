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
public class SunTest {
    private static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");

    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();

    private static Sun sun;

    @BeforeClass
    public static void setSun() {
        sun = (Sun) ac.getBean("sun");
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
        sun.shine();
        Assert.assertEquals("I'm burning bright, sparking well, creating life\r\n", OUTPUT.toString());
    }

    @Test
    public void collapsingShouldBeCorrect() {
        Assert.assertFalse(sun.collapseToBlackHole());
    }

    @Test
    public void movingToTheStarShouldBeCorrect() {
        Star star = mock(Star.class);
        when(star.getName()).thenReturn("Sirius");
        sun.move(10, star);
        Assert.assertEquals("I'm moving to Sirius with speed = 10.0. VERY FAST!!!\r\n", OUTPUT.toString());
    }

    @Test
    public void pullingSpaceObjectShouldBeCorrect() {
        Planet planet = mock(Planet.class);
        when(planet.getName()).thenReturn("Earth");
        sun.pullSpaceObject(planet);
        Assert.assertEquals("I'm pulling Earth <3\r\n", OUTPUT.toString());
    }

    @Test
    public void nameShouldBeCorrect() {
        Assert.assertEquals("Sun", sun.getName());
    }
}
