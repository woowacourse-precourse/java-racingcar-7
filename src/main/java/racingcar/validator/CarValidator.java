package racingcar.validator;

import java.util.HashMap;
import racingcar.message.Message;

public class CarValidator {

    public void validateCarName(String car) {

        if (car.length() > 5 || car.isEmpty()) {
            throw new IllegalArgumentException(Message.ERROR_INVALID_CAR_NAME.getMessage());
        }
    }

    public void checkDuplicateCarName(HashMap<String, Integer> result, String car) {

        if (result.containsKey(car)) {
            throw new IllegalArgumentException(Message.ERROR_DUPLICATE_CAR_NAME.getMessage());
        }
    }
}
