package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String carName;
    private int position;
    private String movementStatus;

    public Car(String carName) {
        this.carName = carName;
        position = 0;
        movementStatus = "";
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public String getMovementStatus() {
        return movementStatus;
    }

    public void isMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            moveForward();
            addMovementStatus();
        }
    }

    public void moveForward() {
        position += 1;
    }

    public void addMovementStatus() {
        movementStatus += "-";
    }

    @Override
    public String toString() {
        return this.carName + " : " + this.movementStatus;
    }
}
