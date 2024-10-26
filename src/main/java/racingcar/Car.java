package racingcar;

import racingcar.io.ConsoleOutputHandler;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private final String carName;
    private int distance = 0; // 달린 누적 거리

    public Car(String carName) {
        this.carName = carName;
    }

    public void moveForwardAttempt(int RANDOM_RANGE_MIN_NUMBER, int RANDOM_RANGE_MAX_NUMBER, int MOVE_FORWARD_MIN_NUMBER) {
        if(pickNumberInRange(RANDOM_RANGE_MIN_NUMBER, RANDOM_RANGE_MAX_NUMBER) > MOVE_FORWARD_MIN_NUMBER) distance++;
    }

}
