package model;

import enums.Direction;
import enums.State;

import java.util.List;

public class Elevator {

    private int elevatorId;
    private int maxCap;
    private Direction currDirection;
    private List<InternalRequest> internalRequests;
    private List<ExternalRequest> externalRequests;
    private State currentState;
    private int currentFloor;

    public Elevator(int elevatorId, int maxCap) {
        this.elevatorId = elevatorId;
        this.maxCap = maxCap;
        this.currDirection = Direction.UP;
        this.currentState = State.IDLE;
        this.currentFloor = 0;
    }

    public void processExternalRequests(ExternalRequest externalRequest) {
        if (currentState.equals(State.IDLE)) {
            if (currentFloor > externalRequest.getCurrentFloor()) {
                currDirection = Direction.DOWN;
            } else {
                currDirection = Direction.UP;
            }
            currentState = State.MOVING;
            currentFloor = externalRequest.getCurrentFloor();
        } else {
//            if (currDirection.equals(externalRequest.getDirection()) && currentFloor < externalRequest.getCurrentFloor())
//                internalRequests.add(internalRequest);
        }

    }

    public void processInternalRequests(ExternalRequest externalRequest) {
        externalRequests.add(externalRequest);
    }

}
