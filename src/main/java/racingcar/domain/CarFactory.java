package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarFactory {

    private static final String INPUT_CAR_NAMES_REGEX = "(\\s*\\w+\\s*)(,\\s*\\w+\\s*)*";

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
        validateCarNames(inputCarNames);

        String[] carNames = splitText(inputCarNames);

        List<Car> carList = Arrays.stream(stripCarNames(carNames))
                .map(Car::new)
                .toList();

        return new Cars(carList);
    }

    private void validateCarNames(String inputCarNames) {
        if (!inputCarNames.matches(INPUT_CAR_NAMES_REGEX)) {
            throw new IllegalArgumentException("자동차 이름은 콤마로 구분해야 합니다");
        }
    }

    private String[] splitText(String inputCarNames) {
        return inputCarNames.split(",");
    }

    private String[] stripCarNames(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].strip();
        }
        return carNames;
    }
}
