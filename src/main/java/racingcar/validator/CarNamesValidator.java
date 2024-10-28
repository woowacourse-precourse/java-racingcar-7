package racingcar.validator;

import racingcar.message.Message;

public class CarNamesValidator {
    public static void validate(String token) {
        if (token.isEmpty()) {
            throw new IllegalArgumentException(Message.CAR_NAME_EMPTY_ERROR_MESSAGE);
        }
        if (token.length() > 5) {
            throw new IllegalArgumentException(Message.CAR_NAME_EXCEED_ERROR_MESSAGE);
        }
    }
}
