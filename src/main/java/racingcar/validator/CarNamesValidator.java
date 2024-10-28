package racingcar.validator;

import racingcar.message.Message;

import java.util.List;

public class CarNamesValidator {
    protected static void isValidLength(List<String> tokens) {
        // test
        for (String token : tokens) {
            if (token.isEmpty()) {
                throw new IllegalArgumentException(Message.CAR_NAME_EMPTY_ERROR_MESSAGE);
            }
            if (token.length() > 5) {
                throw new IllegalArgumentException(Message.CAR_NAME_EXCEED_ERROR_MESSAGE);
            }
        }
    }
    protected static List<String> separate(String userResponse) {
        // separate by comma
        return List.of(userResponse.split("[,]"));
    }
    public static List<String> isCarNamesValid(String userResponse) {
        List<String> tokens = separate(userResponse);
        isValidLength(tokens);
        return tokens;
    }
}
