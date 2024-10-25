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

    public GameController(GameService gameService, VerificationService verificationService, DataTransformService dataTransformService) {
        this.gameService = gameService;
        this.verificationService = verificationService;
        this.dataTransformService = dataTransformService;
    }

    public List<Car> registerCars(String input) {
        verificationService.isValidRegisterCarsInputLength(input);
        verificationService.containsInvalidCharacter(input);
        List<String> carNames = dataTransformService.splitInput(input);

        verificationService.isValidCarNameLength(carNames);
        return dataTransformService.convertToCar(carNames);
    }

    public int registerExecutionNumber(String executionNumberInput) {
        verificationService.isNumber(executionNumberInput);
        verificationService.isValidRange(executionNumberInput);

        return dataTransformService.parseToInt(executionNumberInput);
    }

    public void race(Car racingCar) {
        if(gameService.isMoving()) {
            racingCar.move();
        }
    }

    public List<Car> raceResult(List<Car> cars) {
        return gameService.winners(cars);
    }
}
