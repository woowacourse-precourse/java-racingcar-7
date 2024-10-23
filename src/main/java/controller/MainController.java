package controller;

import factory.CarFactory;
import java.util.List;
import model.Car;
import view.InputHandler;
import view.OutputHandler;

public class MainController {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final CarFactory carFactory;
    private final RacingCarService racingCarService;

    public MainController(InputHandler inputHandler, OutputHandler outputHandler, CarFactory carFactory,
                          RacingCarService racingCarService) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.carFactory = carFactory;
        this.racingCarService = racingCarService;
    }

    public void run() {
        // 흐름 제어 로직
        outputHandler.printGuide();
        List<String> carNames = inputHandler.getCarNames();
        outputHandler.printAttemptPrompt();
        int attempt = inputHandler.getAttemp();
        List<Car> cars = carFactory.createCars(carNames);

        racingCarService.gameStart(cars, attempt);

        // 서비스 계층에 로직 위임

    }
}
