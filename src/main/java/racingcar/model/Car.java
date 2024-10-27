package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int location;

    private Car(String name) {
        validateCarNameLength(name);
        validateCarNameEmpty(name);
        this.name = name;
        this.location = 0;
    }

    public static Car create(String name) {
        return new Car(name);
    }

    private void validateCarNameEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void moveForward() {
        location++;
    }

    public int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String makeStatusResult() {
        return name + " : " + "-".repeat(location);
    }

    public boolean isSameLocation(int winnerLocation) {
        return location == winnerLocation;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
