package racingcar.controller;

import racingcar.model.Car;

import java.util.*;
import java.util.stream.Collectors;

public class CarNameValidator {
    private static final String EMPTY_INPUT_ERROR_MESSAGE = "자동차 이름이 비어있습니다.";
    private static final String NAME_TOO_LONG_ERROR_MESSAGE = "자동차 이름은 5글자를 초과할 수 없습니다.";
    private static final String DUPLICATE_NAME_ERROR_MESSAGE = "자동차 이름이 중복되었습니다 : ";
    public List<Car> validate(String carName) {
        if(!isBlank(carName)) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
        }

        return convert(carName);
    }

    private boolean isBlank(String inputString) {
        return !Objects.isNull(inputString) && !inputString.isBlank();
    }

    private List<Car> convert(String inputString) {
        Set<String> carNameSet = new HashSet<>();
        return Arrays.stream(inputString.split(","))
                .map(carName -> {
                    String car = carName.trim();
                    if (car.isBlank()) {
                        throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
                    }

                    if (car.length() > 5) {
                        throw  new IllegalArgumentException(NAME_TOO_LONG_ERROR_MESSAGE);
                    }

                    if (!carNameSet.add(car)) {
                        throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE + car);
                    }

                    return new Car(car);
                }).collect(Collectors.toList());
    }
}
