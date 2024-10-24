package racingcar.domain;

import static racingcar.util.InputValidator.validateNotBlank;

public class Car {
    private final String name;
    private Integer distance;

    public Car(final String name) {
        validateNotBlank(name);
        validateCarNameLength(name);
        this.name = name;
        this.distance = 0;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= 4) {
            this.distance++;
        }
    }

    public String generateCarState() {
        return this.name + " : " + generateHyphenDistance();
    }

    private String generateHyphenDistance() {
        return "-".repeat(Math.max(0, distance));
    }

    private void validateCarNameLength(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException();
    }
}
