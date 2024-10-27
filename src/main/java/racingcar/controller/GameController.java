package racingcar.controller;

import racingcar.exception.CarNameValidator;
import racingcar.exception.RoundValidator;
import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;
    private final CarService carService;
    private final GameService gameService;

    public GameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.carService = new CarService();
        this.gameService = new GameService();
    }

    public void setGame() {
        outputView.startMessage();
        String carNames = inputView.userInput();

        String[] carNameList = carNames.split(",");
        CarNameValidator.validateCarName(carNameList);

        outputView.roundMessage();
        String roundInput = inputView.userInput();
        int round = RoundValidator.validateRound(roundInput);

        Car[] cars = carService.createCars(carNameList);

        gameService.startGame(cars, round);
    }
}
