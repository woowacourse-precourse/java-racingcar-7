package racingcar.parser;

import racingcar.domain.Car;
import racingcar.domain.Input;
import racingcar.exception.GameErrorMessage;
import racingcar.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private static final String DELIMITER = ",";
    private final InputValidator inputValidator;

    public InputParser(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public List<Car> splitCarsToList(final Input input) {
        List<Car> carList = new ArrayList<>();
        String cars = input.getInput();
        String[] carNames = cars.split(DELIMITER);

        for (String carName : carNames) {
            inputValidator.validateCarNameLength(carName);
            carList.add(Car.create(carName));
        }

        long distinctCount = carList.stream().map(Car::getName).distinct().count();
        if (distinctCount != carList.size()) {
            throw new IllegalArgumentException(GameErrorMessage.CAR_NAME_DUPLICATED.getValue());
        }
        return carList;
    }

    public int parseTryCount(final Input input) {
        try {
            int count = Integer.parseInt(input.getInput());
            inputValidator.validateTryCountGreaterZero(count);
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GameErrorMessage.WRONG_TYPE_TRY_COUNT.getValue());
        }
    }

}
