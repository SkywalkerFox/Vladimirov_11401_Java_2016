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
public class VoyagerTest {
    private static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");

    private final ByteArrayOutputStream OUTPUT = new ByteArrayOutputStream();

    private static Voyager voyager;

    @BeforeClass
    public static void setVoyager() {
        voyager = (Voyager) ac.getBean("voyager");
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
    public void voyagerShouldWorkCorrect() {
        Planet planet = mock(Planet.class);
        when(planet.getName()).thenReturn("Mars");
        voyager.work(planet, 2008);
        Assert.assertEquals("", OUTPUT.toString());
    }

    @Test
    public void nameShouldBeCorrect() {
        Assert.assertEquals(null, voyager.getName());
    }

    @Test
    public void purposeShouldBeCorrect() {
        voyager.getPurpose();
        Assert.assertEquals("", OUTPUT.toString());
    }
}
