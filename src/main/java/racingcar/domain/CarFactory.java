package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarFactory {

    private static CarFactory carFactory;

    private CarFactory() {
    }

    public static CarFactory getInstance() {
        if (carFactory == null) {
            carFactory = new CarFactory();
        }
        return carFactory;
    }

    public Cars createCars(String carNames) {
        List<Car> carList = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .toList();

        return new Cars(carList);
    }
}
