public class RedState implements State {
    private Context context;

    public RedState(Context context) {
        this.context = context;
    }

    @Override
    public void handleTimeout() {
        System.out.println("Traffic light turn green");
        context.setState(new GreenState(context));
    }

    @Override
    public void handlePedestrianWaiting() {
        if(context.isPedestrianWaiting()) {
            System.out.println("Pedestrian button is pressed, pedestrian crossing signal activated");
            try{
                System.out.println("Walk light on");
                Thread.sleep(15000);    // 15 seconds
                System.out.println("Walk light off");
                System.out.println("Do not walk light on");
                Thread.sleep(2000); // 2 seconds
                System.out.println("Do not walk light off");
            }
            catch(InterruptedException ignore) {}
            context.setPedestrianWaiting(false);    // reset pedestrian waiting flag
        }
    }

    @Override
    public int getTimeout() {
        return context.isPedestrianWaiting() ? 10000 : 0; // 10 seconds if pedestrian is waiting, 0 seconds otherwise
    }
}