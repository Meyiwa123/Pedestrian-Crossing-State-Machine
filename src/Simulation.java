public class Simulation {
    public static void main(String[] args) {
        Context context = new Context();

        // start the traffic light simulation in a separate thread
        Thread simulationThread = new Thread(context::runTrafficLight);
        simulationThread.start();

        // simulate a pedestrian pressing the button
        try {
            Thread.sleep(8000); // wait 8 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Pedestrian presses the button");
        context.setPedestrianWaiting(true);
    }
}
