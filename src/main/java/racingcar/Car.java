package racingcar;

public class Car {
    private final String carName;
    private int distance = 0; // 달린 누적 거리

    public Car(String carName) {
        this.carName = carName;
    }
}
