package racingcar;

public class Vehicle {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_RANDOM_FOR_MOVE = 5;
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
    }
}
