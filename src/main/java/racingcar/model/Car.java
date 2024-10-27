package racingcar.model;

import racingcar.util.ErrorMessage;
import racingcar.util.Limit;
import racingcar.util.Regex;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = Limit.DEFAULT.getValue();

        validate();
    }

    private void validate() {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME.getError());
        }
        if (name.length() > Limit.CAR_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.MAX_CAR_NAME_LENGTH.getError());
        }
        if (!name.matches(Regex.DIGIT_AND_ALPHABET.getRegex())) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_FORMAT.getError());
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position += position;
    }
}
