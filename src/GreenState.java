public class GreenState implements State {
    private Context context;

    public GreenState(Context context) {
        this.context = context;
    }

    @Override
    public void handleTimeout() {
        // do nothing there are no pedestrians wanting to cross
        System.out.println("Traffic light remains green");
        context.setState(new GreenState(context));
    }

    @Override
    public void handlePedestrianWaiting() {
        if(context.isPedestrianWaiting()) {
            System.out.println("Pedestrian button pressed during green light, transitioning to yellow");
            System.out.println("Traffic light turns yellow");
            context.setState(new YellowState(context));
        }
    }

    @Override
    public int getTimeout() {
        return 10000; // 10 seconds
    }
}