package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private CarName carName;
    private Position position;

    private RacingCar(CarName carName) {
        this.carName = carName;
        this.position = new Position();
    }

    public static RacingCar of(CarName carName) {
        return new RacingCar(carName);
    }

    public void operatingMoveOrStop() {
        if (isMoveForward()) {
            position.moveForward();
        }
    }

    public CarName getCarName() {
        return carName;
    }

    public int getPosition() {
        return position.getPosition();
    }

    private boolean isMoveForward() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public String toString() {
        String result = "";
        result += carName.carName();
        result += " : ";
        for (int i = 0; i < position.getPosition(); i++) {
            result += "-";
        }
        return result;
    }
}
