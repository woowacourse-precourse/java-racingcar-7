package racingcar.util.validator;

import java.util.Arrays;
import java.util.List;
import racingcar.util.ExceptionMessage;

public class CarNameValidator extends Validator{

    @Override
    public void validate(String input) throws IllegalArgumentException {
        List<String> carNames = Arrays.asList(removeSpace(input).split(","));
       validateNumberofCars(carNames);
       for (String carName : carNames) {
           validateCarNameLength(carName);
       }
    }

    private static void validateCarNameLength(String carName) {
        if(carName.length() >=6) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

    private static void validateNumberofCars(List<String> carNames) {
        if(carNames.size() < 2) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CARS_COUNT.getMessage());
        }
    }
}