package racingcar.entity;

import racingcar.constant.ExceptionMessage;

public class RacingCar {

    private final String name;
    private int distance;

    public RacingCar(String name) {
        String trimName = name.trim();
        validateName(trimName);
        this.name = trimName;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void increaseDistance() {
        this.distance++;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_EMPTY);
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_LENGTH_EXCEED);
        }
    }

}