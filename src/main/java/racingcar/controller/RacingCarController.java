package racingcar.controller;

import java.util.List;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.domain.Result;
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
        Set<String> carNames = InputValidator.validateCarNameInput(inputView.getInput());
        inputView.printRoundCountInputMessage();
        int roundCount = InputValidator.validateRoundCountInput(inputView.getInput());

        List<Car> cars = carService.createCars(carNames);
        List<Result> results = racingService.startRace(cars, roundCount);

        String resultMessage = outputService.generateResultMessage(results);
        String winnerMessage = outputService.generateWinnerMessage(cars);

        outputView.printResult(resultMessage);
        outputView.printWinner(winnerMessage);
        outputView.close();
    }
}
