package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.ExecutionNumber;
import racingcar.service.DataTransformService;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.service.VerificationService;

import java.util.List;

public class GameController {

    private final GameService gameService;
    private final VerificationService verificationService;
    private final DataTransformService dataTransformService;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(GameService gameService, VerificationService verificationService, DataTransformService dataTransformService, InputView inputView, OutputView outputView) {
        this.gameService = gameService;
        this.verificationService = verificationService;
        this.dataTransformService = dataTransformService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<Car> registerCars() {
        outputView.carRegistMessage();
        final String input = inputView.input();

        verificationService.containsInvalidCharacter(input);
        List<String> carNames = dataTransformService.splitInput(input);

        verificationService.isValidLength(carNames);
        return dataTransformService.convertToCar(carNames);
    }

    public int registerExecutionNumber() {
        outputView.countRegistMessage();
        final String executionNumberInput = inputView.input();
        verificationService.isNumber(executionNumberInput);
        verificationService.isValidRange(executionNumberInput);
        outputView.newline();

        return dataTransformService.parseToInt(executionNumberInput);
    }

    public void race(List<Car> cars, ExecutionNumber executionNumber) {
        outputView.executionMessage();
        for (long l = 0; l < executionNumber.getNumber(); l++) {
            cars.stream().filter(c -> gameService.isMoving()).forEach(Car::move);
            outputView.printResult(cars);
            outputView.newline();
        }
    }

    public void raceResult(List<Car> cars) {
        List<Car> winners = gameService.winners(cars);
        outputView.finalWinnerMessage(winners);
    }
}
