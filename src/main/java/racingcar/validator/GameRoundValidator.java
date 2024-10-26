package racingcar.validator;

import java.util.List;

public class GameRoundValidator {
    public static int isGameRoundValid(String userResponse) {
        try {
            int parsedResponse = Integer.parseInt(userResponse);
            if (parsedResponse < 1) {
                throw new IllegalArgumentException("Invalid Game Round Input: value must be 1 or greater");
            }
            return parsedResponse;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid Game Round Input: not integer");
        }
    }
}
