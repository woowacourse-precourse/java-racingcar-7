package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.MessageType;

public class InputMessage {

    public static String inputCarNames() {
        System.out.println(MessageType.REQUEST_INPUT_STRING.getMessage());
        return Console.readLine().trim();
    }

    public static String inputGameAttempts() {
        System.out.println(MessageType.REQUEST_INPUT_TRY_GAME_NUM.getMessage());
        return Console.readLine().trim();
    }

}
