package racingcar.validator;

import racingcar.message.Message;

import java.util.Collections;
import java.util.List;

public class CarNamesValidator {

    public static void validate(String token) {
        if (token.isEmpty()) {
            throw new IllegalArgumentException(Message.CAR_NAME_EMPTY_ERROR_MESSAGE);
        }
        if (token.length() > 5) {
            throw new IllegalArgumentException(Message.CAR_NAME_EXCEED_ERROR_MESSAGE);
        }
    }
    public static void validateDuplicate(List<String> tokens) {
        for (String token : tokens) {
            if (Collections.frequency(tokens, token) > 1) {
                throw new IllegalArgumentException(Message.CAR_NAME_DUPLICATED_ERROR_MESSAGE);
            }
        }
    }

    }
