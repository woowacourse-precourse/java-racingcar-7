package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Validator;
import racingcar.service.CarService;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();
    private final CarService carService;
    private final GameService gameService;

    public GameController(CarService carService, GameService gameService) {
        this.carService = carService;
        this.gameService = gameService;
    }

    public void startGame() {
        int rounds = validator.validateAttemptCount(inputView.inputAttemptCount());
        ArrayList<Car> cars = gameService.getCars();
        outputView.printExecutionResult();
        runRace(rounds, cars);
        printWinners();
    }

    private void runRace(int rounds, ArrayList<Car> cars) {
        for (int i = 0; i < rounds; i++) {
            carService.moveCars();
            outputView.printCarPosition(cars);
            System.out.println();
        }
    }

    private void printWinners() {
        ArrayList<Car> winners = gameService.getWinners();
        outputView.printWinners(winners);
    }
}
