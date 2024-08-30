package model;

import enums.Direction;

public class InternalRequest {

    private int sourceFloor;
    private int destinationFloor;

    public InternalRequest(int sourceFloor, int destinationFloor){
        this.sourceFloor = sourceFloor;
        this.destinationFloor = destinationFloor;
    }
}
