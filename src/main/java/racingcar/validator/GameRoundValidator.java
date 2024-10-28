package racingcar.validator;

import racingcar.message.Message;

public class GameRoundValidator {
    public static void validate(String userResponse) {
        if (userResponse.isEmpty()) {
            throw new IllegalArgumentException(Message.USER_INPUT_EMPTY_ERROR_MESSAGE);
        }
        try {
            int parsedResponse = Integer.parseInt(userResponse);
            if (parsedResponse < 1) {
                throw new IllegalArgumentException(Message.INVALID_GAME_ROUND_INT_ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.INVALID_GAME_ROUND_VALUE_ERROR_MESSAGE);
        }
    }
}
