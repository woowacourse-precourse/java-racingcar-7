package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;
    private static final int MOVE_CONDITION_THRESHOLD = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
        if (randomNumber >= MOVE_CONDITION_THRESHOLD) {
            this.position++;
        }
    }

    public String getResult() {
        String positionDisplay = "-".repeat(position);
        return String.format("%s : %s%n", name, positionDisplay);
    }
}
