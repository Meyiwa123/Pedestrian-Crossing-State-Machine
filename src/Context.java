public class Context {
    private State currentState;
    private boolean pedestrianWaiting;

    public Context() {
        currentState = new GreenState(this);
        pedestrianWaiting = false;
        System.out.println("Traffic light turns green");
    }

    public void setState(State state) {
        currentState = state;
    }

    public void setPedestrianWaiting(boolean waiting) {
        pedestrianWaiting = waiting;
    }

    public Object getState() {
        return currentState;
    }

    public boolean isPedestrianWaiting() {
        return pedestrianWaiting;
    }

    public void runTrafficLight() {
        while(true) {
            try {
                Thread.sleep(currentState.getTimeout());
            } catch (InterruptedException ignore) {}
            currentState.handlePedestrianWaiting();
            currentState.handleTimeout();
        }
    }
}