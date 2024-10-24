package racingcar.domain;

import static racingcar.util.InputValidator.validateNotBlank;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private Integer distance;

    public Car(final String name, Integer distance) {
        validateNotBlank(name);
        validateCarNameLength(name);
        this.name = name;
        this.distance = distance;
    }

    public void moveForward() {
        if (getNumberInRange() >= 4) {

    public void moveForward(int number) {
        if (number >= 4) {
            this.distance++;
        }
    }

    private void validateCarNameLength(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException();
    }
}
