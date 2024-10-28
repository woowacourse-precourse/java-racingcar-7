package racingcar.validator;

import racingcar.message.Message;

public class GameRoundValidator {
    public static int isGameRoundValid(String userResponse) {
        try {
            int parsedResponse = Integer.parseInt(userResponse);
            if (parsedResponse < 1) {
                throw new IllegalArgumentException(Message.INVALID_GAME_ROUND_INT_ERROR_MESSAGE);
            }
            return parsedResponse;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.INVALID_GAME_ROUND_VALUE_ERROR_MESSAGE);
        }
    }
}
