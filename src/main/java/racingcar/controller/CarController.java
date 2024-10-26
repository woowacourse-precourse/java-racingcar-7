package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarService;

public class CarController {
    private static CarController carController;
    private static CarService carService = CarService.getInstance();

    public static CarController getInstance() {
        if (carController == null) {
            carController = new CarController();
        }
        return carController;
    }

    public List<Car> makeCarInstance(String[] carNames){
        return(carService.makeCarInstance(carNames));
    }
}
