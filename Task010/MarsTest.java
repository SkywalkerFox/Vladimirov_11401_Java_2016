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
public class MarsTest {
    private static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");

    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();

    private static Mars mars;

    @BeforeClass
    public static void setMars() {
        mars = (Mars) ac.getBean("mars");
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
        mars.rotate(mars.ROTATION_SPEED);
        Assert.assertEquals("I'm rotating with speed 24.0\r\n", OUTPUT.toString());
    }

    @Test
    public void nameShouldBeCorrect() {
        Assert.assertEquals("Mars", mars.getName());
    }

    @Test
    public void rotationAroundStarShouldBeCorrect() {
        Star star = mock(Star.class);
        when(star.getName()).thenReturn("Sun");
        mars.rotateAroundStar(star);
        Assert.assertEquals("I'm rotating around Sun\r\n", OUTPUT.toString());
    }

}
