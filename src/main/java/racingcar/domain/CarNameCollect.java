package racingcar.domain;

import static racingcar.utils.Constant.COMMA;
import static racingcar.utils.ErrorMessage.INVALID_CAR_NAME;
import static racingcar.utils.ErrorMessage.INVALID_INPUT;

import java.util.Objects;

public class CarNameCollect {

    private final String value;

    protected CarNameCollect(String input) {
        this.value = input;
    }

    public static CarNameCollect create(String input) {
        return new CarNameCollect(validInput(input));
    }


    private static String validInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }

        boolean isStartComma = input.startsWith(COMMA);
        boolean isEndComma = input.endsWith(COMMA);

        if (isStartComma || isEndComma) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }

        return input;
    }


    protected String[] split() {
        String[] splitName = value.split(COMMA);

        if (splitName.length == 0) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
        }

        return splitName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarNameCollect compareCarNameCollect = (CarNameCollect) o;
        return Objects.equals(value, compareCarNameCollect.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
