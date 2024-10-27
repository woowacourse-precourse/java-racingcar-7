package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputMessage {

    public static String inputCarNames() {
        System.out.println(MessageType.REQUEST_INPUT_STRING.getMessage());
        return Console.readLine();
    }

    public static int inputGameAttempts() {
        System.out.println(MessageType.REQUEST_INPUT_TRY_GAME_NUM.getMessage());
        return Integer.parseInt(Console.readLine());
    }

}
