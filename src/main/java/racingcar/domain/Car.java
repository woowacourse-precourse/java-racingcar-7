package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.config.validation.FieldValidation;
import racingcar.config.validation.annotation.Length;

public class Car extends FieldValidation {

    private final static int MOVING_FORWARD = 4;

    @Length(min = 1, max = 5)
    private final String name;

    private int distance = 0;

    private Car(String name) {
        this.name = name;

        super.valid();
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void moveForward() {
        if (Randoms.pickNumberInRange(0, 9) >= MOVING_FORWARD) {
            distance += 1;
        }
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, "-".repeat(distance));
    }
}
