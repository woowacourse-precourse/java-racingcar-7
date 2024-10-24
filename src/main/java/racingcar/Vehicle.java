package racingcar;

public class Vehicle {
    private static final int MAX_NAME_LENGTH = 5;
    private String vehicleName;
    private int victoryCount;

    public Vehicle(String vehicleName) {
        if (vehicleName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (vehicleName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        this.vehicleName = vehicleName;
    }
}
