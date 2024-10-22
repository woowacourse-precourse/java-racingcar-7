package controller;

import domain.Car;
import java.util.List;
import service.RacingService;
import view.InputView;

public class RacingController {
    private final RacingService racingService = new RacingService();
    private List<Car> carsList;

    public void set() {
        String input = InputView.inputCars();
        carsList = racingService.getCarsList(input);
//        for (Car car : carsList) {
//            System.out.println("car.getName() = " + car.getName());
//        }

        String attempt = InputView.inputAttempt();
        System.out.println("attempt = " + attempt);
    }

}
