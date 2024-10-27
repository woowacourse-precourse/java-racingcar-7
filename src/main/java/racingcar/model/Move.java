package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Move {
    private static int MOVE_RATE = 1;
    private static int RANDOM_VALUE_MINIMUM = 0;
    private static int RANDOM_VALUE_MAXIMUM = 9;
    private static int MOVE_STANDARD_VALUE = 4;


    private int createRandomValue() {
        int randomValue = Randoms.pickNumberInRange(RANDOM_VALUE_MINIMUM, RANDOM_VALUE_MAXIMUM);
        return randomValue;
    }

    public boolean checkMovable(int randomValue) {
        if (randomValue >= MOVE_STANDARD_VALUE) return true;
        return false;
    }

    public void moveFoward(Car car) {
        int randomValue = createRandomValue();
        boolean isMovable = checkMovable(randomValue);
        if (isMovable) {
            car.settingPosition(car.getPosition() + MOVE_RATE);
        }
    }
}
