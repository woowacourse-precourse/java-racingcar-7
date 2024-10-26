package racingcar;

import utils.PlayerMoving;

public class RacingCar {
    private String carName;
    private int distance = 0;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    protected void addDistance(){
        if(PlayerMoving.isMoving()){
            distance++;
        }
    }

    public String getCarName(){
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString(){
        return carName + " : " + "-".repeat(distance);
    }

    public int compareTo(int value){
        if(distance > value) {return 1;}
        if(distance == value){ return 0;}
        return -1;
    }

}
