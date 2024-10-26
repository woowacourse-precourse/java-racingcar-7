package racingcar.Validation;

import racingcar.Enum.ErrorMessage;

public class TurnCountValidator {
    public static int validateTurnCount(String turnCount){
        try {
            Integer intTurnCount = Integer.parseInt(turnCount);
            if(intTurnCount < 1){
                throw new IllegalArgumentException(ErrorMessage.INVALID_TURN_NUMBER.getMessage());
            }
            return intTurnCount;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TURN_NUMBER.getMessage());
        }
    }
}
