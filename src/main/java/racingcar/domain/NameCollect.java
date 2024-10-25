package racingcar.domain;

import static racingcar.utils.Constant.COMMA_SEPARATOR;
import static racingcar.utils.Constant.MAX_CAR_NAME_LEN;
import static racingcar.utils.ErrorMessage.INVALID_CAR_NAME;
import static racingcar.utils.ErrorMessage.INVALID_INPUT;

import java.util.Objects;

public class NameCollect {

    private final String value;

    public NameCollect(String input) {
        this.value = validInput(input);
    }

    protected String[] split() {
        String[] splitInput = value.split(COMMA_SEPARATOR);

        if (splitInput.length == 0) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
        }

        return splitInput;
    }

    protected String validName(String name) {
        if (isInvalidName(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
        }

        return name;
    }

    private String validInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }

        boolean isStartComma = input.startsWith(",");
        boolean isEndComma = input.endsWith(",");

        if (isStartComma || isEndComma) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }

        return input;
    }


    private boolean isInvalidName(String name) {
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
        NameCollect compareNameCollect = (NameCollect) o;
        return Objects.equals(value, compareNameCollect.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
