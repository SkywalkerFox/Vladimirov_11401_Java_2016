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
public class SiriusTest {
    private static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");

    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();

    private static Sirius sirius;

    @BeforeClass
    public static void setSirius() {
        sirius = (Sirius) ac.getBean("sirius");
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
        sirius.shine();
        Assert.assertEquals("In the starry sky I burn all the brighter\r\n", OUTPUT.toString());
    }

    @Test
    public void collapsingShouldBeCorrect() {
        Assert.assertFalse(sirius.collapseToBlackHole());
    }

    @Test
    public void movingToTheStarShouldBeCorrect() {
        Star star = mock(Star.class);
        when(star.getName()).thenReturn("Sun");
        sirius.move(10, star);
        Assert.assertEquals("I'm just shining, I do not want to move anywhere\r\n", OUTPUT.toString());
    }

    @Test
    public void pullingSpaceObjectShouldBeCorrect() {
        Planet planet = mock(Planet.class);
        when(planet.getName()).thenReturn("Mars");
        sirius.pullSpaceObject(planet);
        Assert.assertEquals("I'm pulling Mars <3\r\n", OUTPUT.toString());
    }

    @Test
    public void nameShouldBeCorrect() {
        Assert.assertEquals("Sirius", sirius.getName());
    }
}
