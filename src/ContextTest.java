import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ContextTest {
    private Context context;
    @Before
    public void setUp() {
        context = new Context();

        // start the traffic light simulation in a separate thread
        Thread simulationThread = new Thread(context::runTrafficLight);
        simulationThread.start();
    }

    @After
    public void tearDown() {
        context = null;
    }

    @Test
    public void testPedestrianButtonPressed() {
        context.setPedestrianWaiting(true);
        assertTrue(context.isPedestrianWaiting());
    }

    @Test
    public void testEvent() {
        assertEquals(context.getState().getClass(), GreenState.class);

        // start the traffic light simulation in a separate thread
        Thread simulationThread = new Thread(context::runTrafficLight);
        simulationThread.start();

        // simulate a pedestrian pressing the button
        try {
            Thread.sleep(8000); // wait 8 seconds
        } catch (InterruptedException ignore) {}
        context.setPedestrianWaiting(true);

        // wait for state to transition
        try {
            Thread.sleep(5000); // wait 5 seconds
        } catch (InterruptedException ignore) {}

        assertEquals(context.getState().getClass(), RedState.class);
    }
}
