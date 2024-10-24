package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MINIMUM_NUMBER_TO_ADVANCE = 4;
    private static final int RANDOM_NUMBER_LOWER_BOUND = 0;
    private static final int RANDOM_NUMBER_UPPER_BOUND = 9;

    private String name;
    private int status;

    public Car(String name) {
        this.name = name;
        this.status = 0;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public void race() {
        if (pickRandomNumberFromZeroToNine() >= MINIMUM_NUMBER_TO_ADVANCE) {
            status++;
        }
    }

    public String getInformation() {
        return name + " : " + "-".repeat(status);
    }

    private int pickRandomNumberFromZeroToNine() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_LOWER_BOUND, RANDOM_NUMBER_UPPER_BOUND);
    }
}
