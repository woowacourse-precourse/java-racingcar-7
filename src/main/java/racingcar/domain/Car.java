package racingcar.domain;

import java.util.*;

public class Car {

    private final List<String> cars;

    private Car(String input) {
        List<String> carNames = splitByComma(input);
        Validator.validateCars(carNames);
        this.cars = carNames;
    }

    public static Car from(String input) {
        return new Car(input);
    }

    public List<String> getCars() {
        return cars;
    }

    private static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(","))
                .toList();
    }

    private static class Validator {

        private final static int MAX_CAR_NAME_LENGTH = 5;

        private static void validateCars(List<String> cars) {
            validateCarNames(cars);
        }

        private static void validateCarNames(List<String> carNames) {
            carNames.forEach(name -> {
                if (name.length() > MAX_CAR_NAME_LENGTH) {
                    throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
                }
            });
        }
    }

}