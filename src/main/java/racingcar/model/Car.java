package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (isMoveForward()) {
            this.position++;
        }
    }

    private boolean isMoveForward() {
        return generateRandomNumber() >= MOVE_THRESHOLD;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}