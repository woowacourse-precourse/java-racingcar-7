package racingcar.model.domain;

import racingcar.common.exception.ErrorCode;
import racingcar.common.exception.GameException;

public class Car {
    private final String name;
    private final StringBuilder status;

    private Car(String name) {
        validateInput(name);
        this.name = name;
        this.status = new StringBuilder();
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public String getStatus() {
        return this.status.toString();
    }

    public String getName() {
        return name;
    }

    public void move() {
        this.status.append("-");
    }

    public String getProgress() {
        return String.format("%s : %s\n", this.getName(), this.getStatus());
    }

    public int getPosition() {
        return this.status.toString().length();
    }

    private void validateInput(String name) {
        if (name.length() > 5 || name.isBlank()) {
            throw new GameException(ErrorCode.LENGTH_ERROR);
        }
    }
}
