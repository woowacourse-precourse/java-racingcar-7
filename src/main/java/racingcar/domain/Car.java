package racingcar.domain;

import static racingcar.exception.ExceptionMessage.*;

public class Car {
    private final String name;
    private int position;


    public Car(String name) {
        this.name = name;
        validateCarName();
        this.position = 0;
    }

    public void move(int randomNum) {
        if (randomNum >= 4) {
            position += 1;
        }
    }

    void validateCarName() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME);
        }
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_TOO_LONG);
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
