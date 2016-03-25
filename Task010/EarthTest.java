import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ����� on 25.02.2016.
 */
public class EarthTest {

    private static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");

    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();

    private static Earth earth;

    @BeforeClass
    public static void setEarth() {
        earth = (Earth) ac.getBean("earth");
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
