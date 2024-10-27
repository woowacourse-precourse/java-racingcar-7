package racingcar.model.domain;

import static racingcar.constant.Constant.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String carName;
    private int currentDistance;

    public Car(String carName) {
        this.carName = carName;
        this.currentDistance = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getCurrentDistance() {
        return currentDistance;
    }

    public void moveConditionally() {
        int random = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
        if (random >= MOVE_THRESHOLD) {
            increaseDistance();
        }
    }

    private void increaseDistance() {
        currentDistance += MOVE_INCREMENT;
    }
}
