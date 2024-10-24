package racingcar.model;

import static racingcar.global.GameConstant.NAME_POSITION_DELIMITER;
import static racingcar.global.GameConstant.POSITION_NOTATION;

public class Car {

    private final String name;
    private int position;

    private Car(final String name) {
        checkNameLength(name);
        this.name = name;
        this.position = 0;
    }

    public static Car from(final String name) {
        return new Car(name);
    }

    private void checkNameLength(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    public void move(final int number) {
        if (number >= 4) {
            position++;
        }
    }

    public boolean isNotSamePositionTo(final int position) {
        return this.position != position;
    }

    public String getCurrentSituation() {
        return name +
            NAME_POSITION_DELIMITER +
            POSITION_NOTATION.repeat(Math.max(0, position));
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
