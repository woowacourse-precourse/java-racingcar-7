package racingcar.controller;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CarNameValidator {
    private static final String EMPTY_INPUT_ERROR_MESSAGE = "자동차 이름이 비어있습니다.";
    private static final String NAME_TOO_LONG_ERROR_MESSAGE = "자동차 이름은 5글자를 초과할 수 없습니다.";
    public List<Car> validate(String carName) {
        if(!isEmpty(carName)) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
        }

        return convert(carName);
    }

    private boolean isEmpty(String inputString) {
        return !Objects.isNull(inputString) && !inputString.isBlank();
    }

    private List<Car> convert(String inputString) {
        return Arrays.stream(inputString.split(","))
                .map(carName -> {
                    String car = carName.trim();
                    if (car.isBlank()) {
                        throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
                    }
                    else if (car.length() > 5) {
                        throw  new IllegalArgumentException(NAME_TOO_LONG_ERROR_MESSAGE);
                    }
                    return new Car(car);
                }).collect(Collectors.toList());
    }
}
