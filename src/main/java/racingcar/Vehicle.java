package racingcar;

public class Vehicle {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_RANDOM_FOR_MOVE = 4;
    private static final int MIN_DISTANCE = 0;
    public static int MAX_RACE_DISTANCE = 0;

    private String vehicleName;
    private int currentDistance;

    public Vehicle(String vehicleName) {
        if (vehicleName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (vehicleName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
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
        String distance = "-".repeat(Math.max(MIN_DISTANCE, currentDistance));
        return vehicleName + " : " + distance;
    }
}
