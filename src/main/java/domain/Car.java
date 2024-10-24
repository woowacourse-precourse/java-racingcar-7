package domain;

public class Car {
    private String carName;
    private String carLocation;

    // 생성자(객체)
    public Car(final String carName, final String carLocation) {
        this.carName = carName;
        this.carLocation = carLocation;
    }

    // 자동차의 현재 위치
    public String gerCarLocation() {
        return carLocation;
    }
}
