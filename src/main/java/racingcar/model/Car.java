package racingcar.model;

import racingcar.message.ExceptionCode;

public class Car {

    private final String name;
    private final Distance distance;

    public Car(final String name, final Distance distance) {
        this.name = validate(name);
        this.distance = distance;
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
        distance.moveOrNot();
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance.getPosition();
    }

}
