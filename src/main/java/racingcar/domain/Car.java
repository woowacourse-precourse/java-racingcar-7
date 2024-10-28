package racingcar.domain;

import racingcar.utils.ErrorMessage;

public class Car {
    private static final int MOVED_BOUND = 4;
    private static final String POSITION_FORMAT_SYMBOL = "-";
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_NULL.message());
        }
        if (name.length() >= 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_OVER_RANGE.message());
        }
        if (!name.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_FORMAT.message());
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVED_BOUND) {
            position++;
        }
    }

    public boolean isWinner(int maxPosition) {
        return this.position == maxPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getCurrentStateFormat() {
        String stateFormat = "%s : %s";
        String positionFormat = POSITION_FORMAT_SYMBOL.repeat(position);
        return String.format(stateFormat, name, positionFormat);
    }
}

