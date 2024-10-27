package racingcar.racing;

public class CarFactory {
    public Car[] createRacingCars(String carNames) {
        String[] carName = carNames.split(",");
        Car[] cars = new Car[carName.length];

        for (int i = 0; i < carName.length; i++) {
            cars[i] = new Car(carName[i].trim());
        }

        return cars;
    }
}
