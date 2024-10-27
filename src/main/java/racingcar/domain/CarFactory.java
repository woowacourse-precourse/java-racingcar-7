package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.constants.Constants;

public class CarFactory {

    private static final String CAR_NAMES_REGEX = "(\\s*\\w+\\s*)(,\\s*\\w+\\s*)*";
    private static final String COMMA = ",";

    private static CarFactory carFactory;

    private CarFactory() {
    }

    public static CarFactory getInstance() {
        if (carFactory == null) {
            carFactory = new CarFactory();
        }
        return carFactory;
    }

    public Cars createCars(String inputCarNames) {
        checkDividedComma(inputCarNames);

        List<String> carNames = removeSpaces(splitText(inputCarNames));

        List<Car> carList = carNames.stream()
                .map(Car::new)
                .toList();

        return new Cars(carList);
    }

    private void checkDividedComma(String inputCarNames) {
        if (isNotDividedComma(inputCarNames)) {
            throw new IllegalArgumentException(Constants.NOT_CAR_NAMES_DIVIDED_COMMA);
        }
    }

    private boolean isNotDividedComma(String inputCarNames) {
        return !inputCarNames.matches(CAR_NAMES_REGEX);
    }

    private String[] splitText(String inputCarNames) {
        return inputCarNames.split(COMMA);
    }

    private List<String> removeSpaces(String[] carNames) {
        return Arrays.stream(carNames).map(String::strip).toList();
    }
}
