package racingcar.domain;

import static racingcar.utils.Constant.MAX_CAR_NAME_LEN;
import static racingcar.utils.ErrorMessage.INVALID_CAR_NAME;
import static racingcar.utils.ErrorMessage.INVALID_INPUT;

import java.util.Objects;

public class Input {

    private final String value;

    public Input(String input) {
        this.value = invalidInput(input);
    }

    protected String[] splitInput() {
        String[] splitInput = value.split(",");

        if (splitInput.length == 0) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
        }

        return splitInput;
    }

    protected String validName(String name) {
        if (isInValidName(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
        }

        return name;
    }

    private String invalidInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }

        return input;
    }


    private boolean isInValidName(String name) {
        int length = name.length();

        return length == 0 || length > MAX_CAR_NAME_LEN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Input compareInput = (Input) o;
        return Objects.equals(value, compareInput.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
