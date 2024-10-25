package racingcar.controller;

import java.util.HashSet;
import java.util.Set;
import racingcar.exception.carName.DuplicateCarNameException;
import racingcar.model.Car;
import racingcar.service.DataTransformService;
import racingcar.service.GameService;
import racingcar.service.VerificationService;

import java.util.List;

public class GameController {

    private final GameService gameService;
    private final VerificationService verificationService;
    private final DataTransformService dataTransformService;

    public GameController(final GameService gameService, final VerificationService verificationService, final DataTransformService dataTransformService) {
        this.gameService = gameService;
        this.verificationService = verificationService;
        this.dataTransformService = dataTransformService;
    }

    public List<Car> registerCars(final String input) {
        verificationService.isValidRegisterCarsInputLength(input);
        verificationService.containsInvalidCharacter(input);
        List<String> carNames = dataTransformService.splitInput(input);

        verificationService.isValidCarNameLength(carNames);
        List<Car> cars = dataTransformService.convertToCar(carNames);
        Set<Car> deduplicationCars = new HashSet<>(cars);
        if(cars.size() != deduplicationCars.size()) {
            throw new DuplicateCarNameException();
        }
        return cars;
    }

    public int registerExecutionNumber(final String executionNumberInput) {
        verificationService.isNumber(executionNumberInput);
        verificationService.isValidExecutionRange(executionNumberInput);

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
