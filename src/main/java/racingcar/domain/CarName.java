package racingcar.domain;

public class CarName {
    private final String carName;

    private CarName(String carName) {
        this.carName = carName;
    }

    public static CarName from(String carName) {
        return new CarName(carName);
    }
}
