public class YellowState implements State {
    private Context context;

    public YellowState(Context context) {
        this.context = context;
    }
    @Override
    public void handleTimeout() {
        System.out.println("Traffic light turns red");
        context.setState(new RedState(context));
    }

    @Override
    public void handlePedestrianWaiting() {
        // do nothing, pedestrian crossing signal is inactive during yellow state
    }

    @Override
    public int getTimeout() {
        return 3000; // 3 seconds
    }
}