package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.util.Utils;

public class CarController {
    private static CarController carController;
    private static CarService carService = CarService.getInstance();
    private static ViewController viewController = ViewController.getInstance();

    public static CarController getInstance() {
        if (carController == null) {
            carController = new CarController();
        }
        return carController;
    }

    public List<Car> makeCarInstance(String[] carNames){
        return(carService.makeCarInstance(carNames));
    }

    public void advanceCar(List<Car> cars) {
        for (int i = 0; i < Utils.getAdvaceCount(); i++) {
            carService.advanceCar(cars);
            viewController.printAdvance(cars);
        }
    }

    public List<String> findWinner(List<Car> cars) {
        return carService.findWinner(cars);
    }
}
