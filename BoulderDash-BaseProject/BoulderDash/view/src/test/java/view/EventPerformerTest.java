package view;

import static org.junit.Assert.assertNotNull;

import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EventPerformerTest {

	EventPerformer test;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        test = new EventPerformer();
    }

    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Key typed.
     *
     * @throws Exception the exception
     */
    @Test
    public void keyTyped() throws Exception {
        final int expected = KeyEvent.VK_UP;
        assertNotNull(test.keyTyped(expected));
}

}
