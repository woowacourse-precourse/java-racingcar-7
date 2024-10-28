package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.message.ExceptionCode;

public class Car {

    private static final int RANDOM_EXPECTED = 4;

    private final String name;
    private int distance;

    public Car(final String name) {
        this.name = validate(name);
        this.distance = 0;
    }

    private String validate(final String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionCode.CAR_NAME_BLANK.getDescription());
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException(ExceptionCode.CAR_NAME_LENGTH_5.getDescription());
        }

        return name;
    }

    public void goOrStop() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= RANDOM_EXPECTED) {
            this.distance += 1;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }


}
