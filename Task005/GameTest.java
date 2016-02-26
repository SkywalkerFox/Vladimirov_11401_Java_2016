import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.FileNotFoundException;

/**
 * Created by Павел on 26.02.2016.
 */
public class GameTest {
    private static GameFrame gameFrame;

    @Before
    public void setGameFrame() throws FileNotFoundException {
        gameFrame = new GameFrame();
    }

    @Test
    public void flipWordShouldWorkCorrect() {
        Assert.assertEquals("good", gameFrame.flipWord("doog"));
    }
}
