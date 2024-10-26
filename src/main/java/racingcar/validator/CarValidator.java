package racingcar.validator;

import java.util.HashMap;
import racingcar.message.Message;

public class CarValidator {

    private String errorMessage;

    public void validateCarName(String car) {

        errorMessage = String.format(Message.ERROR_INVALID_CAR_NAME.getMessage());

        if (car.length() > 5 || car.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void checkDuplicateCarName(HashMap<String, Integer> result, String car) {

        errorMessage = String.format(Message.ERROR_DUPLICATE_CAR_NAME.getMessage());

        if (result.containsKey(car)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
