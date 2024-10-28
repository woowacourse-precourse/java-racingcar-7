package racingcar.dto;

import racingcar.validator.GameRoundValidator;

public class GameRoundInputHandler {
    public static void handle(String userResponse) {
        GameRoundValidator.validate(userResponse);
    }
}
