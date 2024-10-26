package racingcar.model;

public record CarName(String carName) {
    public static CarName of(String carName) {
        return new CarName(carName);
    }
}
