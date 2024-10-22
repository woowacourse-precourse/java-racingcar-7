package controller;

import domain.Car;
import java.util.List;
import service.RacingService;
import view.InputView;
import view.OutputView;

public class RacingController {
    private final RacingService racingService = new RacingService();
    private List<Car> carsList;
    private int attempt;

    public void set() {
        String input = InputView.inputCars();
        carsList = racingService.getCarsList(input);

        attempt = Integer.parseInt(InputView.inputAttempt());

        start();
    }

    public void start() {
        for (int i = 0; i < attempt; i++) {
            racingService.moveCars(carsList);
            OutputView.showRoundResult(carsList);
        }
    }


}
