public interface State {
    void handleTimeout();
    void handlePedestrianWaiting();
    int getTimeout();
}