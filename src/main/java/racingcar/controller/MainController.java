package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;

public class MainController {
    private static ViewController viewController = ViewController.getInstance();
    private static CarController carController = CarController.getInstance();
    public static void run(){
        String[] carNames = viewController.printGuide();
        List<Car> cars = carController.makeCarInstance(carNames);
        viewController.printCountGuide();
        carController.advanceCar(cars);
        List<String> winnerNames = carController.findWinner(cars);
        viewController.printWinner(winnerNames);
    }
}
