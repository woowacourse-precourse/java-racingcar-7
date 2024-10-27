package racingcar;

import utils.PlayerMoving;

public class RacingCar {
    private String carName;
    private int distance = 0;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    protected void addDistance(){
        if(PlayerMoving.isMoveAble()){
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

    public boolean isNewWinner(int previousHighestDistance){
        return distance>previousHighestDistance;
    }

    public boolean isSameDistance(int highestDistance){
        return distance == highestDistance;
    }
}
