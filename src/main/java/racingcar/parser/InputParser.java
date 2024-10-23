package racingcar.parser;

import racingcar.domain.Car;
import racingcar.domain.Input;
import racingcar.validator.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
            carList.add(new Car(carName));
        }

        long distinctCount = carList.stream().map(Car::getName).distinct().count();
        if (distinctCount != carList.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다. 자동차 이름은 중복되면 안됩니다.");
        }
        return carList;
    }

    public int parseTryCount(final Input input) {
        try {
            int count = Integer.parseInt(input.getInput());
            inputValidator.validateTryCountGreaterZero(count);
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 형태의 시도 횟수입니다.");
        }
    }

}
