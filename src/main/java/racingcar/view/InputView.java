package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import racingcar.message.Message;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static List<String> getCarNames() {
        System.out.print(Message.CAR_NAMES_REQUEST_MESSAGE);
        return Arrays.asList(Console.readLine().split("[,]"));
    }

    public static String getGameRound() {
        System.out.print(Message.GAME_ROUND_REQUEST_MESSAGE);
        return Console.readLine();
    }
}
