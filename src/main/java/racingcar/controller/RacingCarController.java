package racingcar.controller;

import racingcar.domain.car.CarNames;
import racingcar.domain.car.Cars;
import racingcar.domain.race.Results;
import racingcar.service.CarService;
import racingcar.service.OutputService;
import racingcar.service.RacingService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarService carService;
    private final RacingService racingService;
    private final OutputService outputService;

    public RacingCarController(InputView inputView, OutputView outputView, CarService carService,
                               RacingService racingService, OutputService outputService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carService = carService;
        this.racingService = racingService;
        this.outputService = outputService;
    }

    public void run() {
        inputView.printCarNameInputMessage();
        CarNames carNames = InputValidator.validateCarNameInput(inputView.getInput());
        inputView.printRoundCountInputMessage();
        int roundCount = InputValidator.validateRoundCountInput(inputView.getInput());

        Cars cars = carService.createCars(carNames);
        Results results = racingService.startRace(cars, roundCount);

        String resultMessage = outputService.generateResultMessage(results);
        String winnerMessage = outputService.generateWinnerMessage(cars);

        outputView.printResult(resultMessage);
        outputView.printWinner(winnerMessage);
        outputView.close();
    }
}
