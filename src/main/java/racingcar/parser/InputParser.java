package racingcar.parser;

import racingcar.domain.Car;
import racingcar.domain.Input;
import racingcar.exception.GameErrorMessage;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private static final String DELIMITER = ",";
    private final CarNameValidator carNameValidator;
    private final TryCountValidator tryCountValidator;

    protected InputParser(final CarNameValidator carNameValidator, final TryCountValidator tryCountValidator) {
        this.carNameValidator = carNameValidator;
        this.tryCountValidator = tryCountValidator;
    }

    public List<Car> parseRacingCarList(final Input input) {
        List<Car> carList = splitCarsToList(input.getInput());
        carNameValidator.validateCarNamesUnique(carList);
        return carList;
    }

    private List<Car> splitCarsToList(final String cars) {
        String[] carNames = cars.split(DELIMITER);
        return createCarList(carNames);
    }

    private List<Car> createCarList(final String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carNameValidator.validateCarNameLength(carName);
            carList.add(Car.create(carName));
        }
        return carList;
    }

    public int parseTryCount(final Input input) {
        int count = parseInteger(input.getInput());
        tryCountValidator.validateTryCountGreaterZero(count);
        return count;
    }

    private int parseInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GameErrorMessage.WRONG_TYPE_TRY_COUNT.getValue());
        }
    }

}
