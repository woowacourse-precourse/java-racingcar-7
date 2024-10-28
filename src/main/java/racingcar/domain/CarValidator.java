package racingcar.domain;

import static racingcar.exception.Exception.CAR_NAME_ALREADY_EXIST;
import static racingcar.exception.Exception.CAR_NAME_TOO_LONG;
import static racingcar.exception.Exception.INVALID_CAR_NAME_FORMAT;
import static racingcar.exception.Exception.INVALID_EMPTY_CAR_NAME;
import static racingcar.exception.Exception.NOT_ENOUGH_CARS;
import static racingcar.exception.Exception.TOO_MANY_CARS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarValidator {

    public static void validate(List<Car> cars) {
        validateCarsCount(cars);
        validateSingleCar(cars);
        validateIndividualCarNames(cars);
    }

    private static void validateCarsCount(List<Car> cars) {
        if (cars.size() > 5) {
            throw new IllegalArgumentException(TOO_MANY_CARS.getMessage());
        }
    }

    private static void validateSingleCar(List<Car> cars) {
        if (cars.size() == 1) {
            throw new IllegalArgumentException(NOT_ENOUGH_CARS.getMessage());
        }
    }

    private static void validateIndividualCarNames(List<Car> cars){
        Set<String> uniqueNames = new HashSet<>();

        for (Car car : cars) {
            String name = car.getCarName().trim();

            validateEmptyName(name);
            validateNameLength(name);
            validateNameCharacters(name);
            validateDuplicateCarName(name, uniqueNames);
        }
    }

    private static void validateEmptyName(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException(INVALID_EMPTY_CAR_NAME.getMessage());
        }
    }

    private static void validateNameLength(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException(CAR_NAME_TOO_LONG.getMessage() + name);
        }
    }

    private static void validateNameCharacters(String name){
        if(!name.matches("[a-zA-Z가-힣]+")){
            throw new IllegalArgumentException(INVALID_CAR_NAME_FORMAT.getMessage() + name);
        }
    }

    private static void validateDuplicateCarName(String name, Set<String> uniqueNames) {
        if(!uniqueNames.add(name)) {
            throw new IllegalArgumentException(CAR_NAME_ALREADY_EXIST.getMessage() + name);
        }
    }
}
