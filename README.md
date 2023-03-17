# Pedestrian Crossing State Machine

## States
The code implements a simple traffic light system with pedestrian crossing. The system has three states:

1. Green state: The traffic light is green and vehicles can move through. If a pedestrian wants to cross he/she will have to wait presses the pedestrian button during this state, the state transitions to Yellow state.

2. Yellow state: The traffic light is yellow after a fixed time, the state transitions to Red state.

3. Red state: The traffic light is red, indicating that vehicles should stop. The pedestrian crossing signal is active during this state, allowing pedestrians to cross the street. After a fixed time, the state transitions back to Green state.

## Description

The Context class represents the context in which the states operate. It has a reference to the current state and a boolean flag indicating whether a pedestrian is waiting to cross the street.

The State interface defines two methods that each state must implement: handleTimeout() and handlePedestrianWaiting(). The handleTimeout() method is called when the timer for the current state expires, and the handlePedestrianWaiting() method is called when a pedestrian presses the pedestrian button.

The GreenState, YellowState, and RedState classes implement the State interface and represent the three states of the traffic light system. Each state class implements its own behavior for the handleTimeout() and handlePedestrianWaiting() methods.

When the program is run, it creates a new Context object, which sets the initial state to GreenState. The runTrafficLight() method is called to start the traffic light cycle, which alternates between the three states depending on if the pedestrian wants to cross. The program prints messages to the console to indicate which state the traffic light is in and whether a pedestrian is waiting to cross the street.
