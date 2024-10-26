package racingcar.validation;

import racingcar.error.ErrorMessage;
import racingcar.model.Car;
import racingcar.utils.Utils;

import java.util.List;

public class InputValidation {
    private static final String DELIMITER = ",";
    private static final int MAX_CHARACTER_LENGTH = 5;
    private static final int MAX_INTEGER_LENGTH = 10;

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

    public static void validateIntRange(String number){
        if(number.length() > MAX_INTEGER_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.OVERFLOW_NUMBER.getMessage());
        }
    }

    public static void validateNumberFormat(String number){
        if(!Utils.isNumeric(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }

    public static void validatePositiveNumber(String number){
        if(Integer.parseInt(number) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NON_POSITIVE_INTEGER.getMessage());
        }
    }
}
