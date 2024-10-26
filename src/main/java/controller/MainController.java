package controller;

import factory.CarFactory;
import java.util.List;
import model.Car;
import view.InputView;
import view.OutputHandler;

public class MainController {
    private final InputView inputView;
    private final OutputHandler outputHandler;
    private final CarFactory carFactory;
    private final RacingCarService racingCarService;

    public MainController(InputView inputView, OutputHandler outputHandler, CarFactory carFactory,
                          RacingCarService racingCarService) {
        this.inputView = inputView;
        this.outputHandler = outputHandler;
        this.carFactory = carFactory;
        this.racingCarService = racingCarService;
    }

    public void run() {
        // 흐름 제어 로직
        outputHandler.printGuide();
        List<String> carNames = inputView.getCarNames();
        outputHandler.printAttemptPrompt();
        int attempt = inputView.getAttemptCount();
        List<Car> cars = carFactory.createCars(carNames);

        racingCarService.gameStart(cars, attempt);
        List<String> winners = outputHandler.findFinalWinners(cars);
        outputHandler.printFinalWinner(winners);
        // 서비스 계층에 로직 위임

    }
}
