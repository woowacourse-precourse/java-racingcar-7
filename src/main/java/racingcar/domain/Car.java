package racingcar.domain;

import static racingcar.exception.Exception.EMPTY_NAME;
import static racingcar.exception.Exception.INVALID_NAME_LENGTH;

import java.util.stream.IntStream;
import racingcar.domain.strategy.CarDrivingStrategy;

public class Car {

    private static final int ZERO = 0;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String POSITION_SYMBOL = "-";
    private static final String NAME_POSITION_SEPARATOR = " : ";

    private final String name;
    private int position;

    public Car(final String name) {
        validate(name);
        this.name = name;
        this.position = ZERO;
    }

    private void validate(final String name) {
        validateNonEmpty(name);
        validateLength(name);
    }

    private void validateNonEmpty(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(EMPTY_NAME.getMessage());
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH.getMessage());
        }
    }

    public void move(final CarDrivingStrategy strategy) {
        if (strategy.driving()) {
            position++;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(NAME_POSITION_SEPARATOR);
        IntStream.range(ZERO, position).forEach(i -> stringBuilder.append(POSITION_SYMBOL));
        return stringBuilder.toString();
    }
}
