package racingcar.model;

import static racingcar.constant.ErrorMessage.VEHICLE_NAME_CANNOT_BE_EMPTY;
import static racingcar.constant.ErrorMessage.VEHICLE_NAME_CANNOT_BE_MORE_FIVE;

public class Vehicle {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_RANDOM_FOR_MOVE = 4;
    private static final int MIN_DISTANCE = 0;
    private static final String MOVE_SYMBOL = "-";
    public static int MAX_RACE_DISTANCE = 0;

    private String vehicleName;
    private int currentDistance;

    public Vehicle(String vehicleName) {
        if (vehicleName == null || vehicleName.isBlank()) {
            throw new IllegalArgumentException(VEHICLE_NAME_CANNOT_BE_EMPTY);
        }
        if (vehicleName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(VEHICLE_NAME_CANNOT_BE_MORE_FIVE);
        }
        this.vehicleName = vehicleName;
    }

    public void moveOrStay(int randomValue) {
        if (randomValue >= MIN_RANDOM_FOR_MOVE) {
            this.currentDistance++;
        }
        MAX_RACE_DISTANCE = Math.max(MAX_RACE_DISTANCE, currentDistance);
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public int getCurrentDistance() {
        return currentDistance;
    }

    public String getCurrentDistanceToSymbol() {
        String distance = MOVE_SYMBOL.repeat(Math.max(MIN_DISTANCE, currentDistance));
        return vehicleName + " : " + distance;
    }
}
