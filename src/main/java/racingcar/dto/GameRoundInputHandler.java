package racingcar.dto;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.Message;
import racingcar.validator.GameRoundValidator;

public class GameRoundInputHandler {
    String userResponse;
    public String getUserResponse() {
        System.out.print(Message.GAME_ROUND_REQUEST_MESSAGE);
        this.userResponse = Console.readLine();
        return userResponse;
    }
    public int validateUserResponse() {
        if (this.userResponse.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return GameRoundValidator.isGameRoundValid(userResponse);
    }
}
