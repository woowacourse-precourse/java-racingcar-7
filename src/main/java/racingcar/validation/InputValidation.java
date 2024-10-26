package racingcar.validation;

import racingcar.error.ErrorMessage;
import racingcar.model.Car;

import java.util.List;

public class InputValidation {
    private static final String DELIMITER = ",";
    private static final int MAX_CHARACTER_LENGTH = 5;

    public static void validateDelimiter(String input){
        if(!input.contains(DELIMITER)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER.getMessage());
        }
    }

    public static void validateNameLength(List<Car> cars) {
        cars.stream()
                .filter(car -> car.getName().length() > MAX_CHARACTER_LENGTH)
                .findAny()
                .ifPresent(car -> {
                    throw new IllegalArgumentException(ErrorMessage.LONG_NAME_LENGTH.getMessage());
                });
    }
}
