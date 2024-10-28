package racingcar.model;

public class CarRepository {
    private final Car[] cars;

    public CarRepository(String[] carNames) {
        cars = new Car[carNames.length];

        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    public Car[] getCars() {
        return cars;
    }
}
