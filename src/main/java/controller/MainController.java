package controller;

import factory.CarFactory;
import java.util.List;
import model.Car;
import view.InputView;
import view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarFactory carFactory;
    private final RacingCarService racingCarService;

    public MainController(InputView inputView, OutputView outputView, CarFactory carFactory,
                          RacingCarService racingCarService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carFactory = carFactory;
        this.racingCarService = racingCarService;
    }

    public void run() {
        // 흐름 제어 로직
        outputView.printGuide();
        List<String> carNames = inputView.getCarNames();
        outputView.printAttemptPrompt();
        int attempt = inputView.getAttemptCount();
        List<Car> cars = carFactory.createCars(carNames);

        racingCarService.gameStart(cars, attempt);
        List<String> winners = outputView.findFinalWinners(cars);
        outputView.printFinalWinner(winners);
        // 서비스 계층에 로직 위임

    }
}
