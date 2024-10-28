package racingcar.car;

import java.util.List;

public class CarController {
    private final CarService carService = new CarService();

    public List<Car> createCar(String inputCar) {
        return carService.createCar(inputCar);
    }
}
