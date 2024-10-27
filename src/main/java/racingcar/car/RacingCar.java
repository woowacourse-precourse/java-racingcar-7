package racingcar.car;

import racingcar.strategy.MoveStrategy;

public class RacingCar {

    private final String carName;
    private int distance;

    public RacingCar(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return carName;
    }

    public void moveForwardOneStep(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            distance += 1;
        }
    }

    public void printMoveStatus() {
        String currentCarStatus = carName + " : " + "-".repeat(distance);
        System.out.println(currentCarStatus);
    }


}
