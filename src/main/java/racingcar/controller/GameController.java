package racingcar.controller;

import java.util.HashSet;
import java.util.Set;
import racingcar.exception.carName.DuplicateCarNameException;
import racingcar.model.Car;
import racingcar.model.factory.CarFactory;
import racingcar.util.DataTransformUtil;
import racingcar.service.GameService;
import racingcar.util.ValidationUtil;

import java.util.List;

import static racingcar.util.constant.CharacterConstant.CAR_DELIMITER;

public class GameController {

    private final GameService gameService;
    private final ValidationUtil validationUtil;
    private final DataTransformUtil dataTransformUtil;

    public GameController(final GameService gameService, final ValidationUtil validationUtil, final DataTransformUtil dataTransformUtil) {
        this.gameService = gameService;
        this.validationUtil = validationUtil;
        this.dataTransformUtil = dataTransformUtil;
    }

    public List<Car> registerCars(final String input) {
        validationUtil.isValidRegisterCarsInputLength(input);
        validationUtil.containsInvalidCharacter(input);
        List<String> carNames = dataTransformUtil.splitInput(input, String.valueOf(CAR_DELIMITER.getCharacter()));

        validationUtil.isValidCarNameLength(carNames);
        List<Car> cars = CarFactory.convertToCar(carNames);
        Set<Car> deduplicationCars = new HashSet<>(cars);
        if(cars.size() != deduplicationCars.size()) {
            throw new DuplicateCarNameException();
        }
        return cars;
    }

    public int registerExecutionNumber(final String executionNumberInput) {
        validationUtil.isNumber(executionNumberInput);
        validationUtil.isValidExecutionRange(executionNumberInput);

        return dataTransformUtil.parseToInt(executionNumberInput);
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
