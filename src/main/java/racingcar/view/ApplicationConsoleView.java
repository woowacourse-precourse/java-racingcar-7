package racingcar.view;

import static racingcar.common.ConsoleMessage.*;
import static racingcar.common.FormatConstants.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ApplicationConsoleView implements ApplicationView {

    @Override
    public String requestInputCars() {
        println(REQUEST_INPUT_RACING_CARS);
        return Console.readLine();
    }

    @Override
    public int requestGameCount() {
        println(REQUEST_INPUT_GAME_COUNT);
        return Integer.parseInt(Console.readLine());
    }

    @Override
    public void printRacingProgressResult(List<String> results) {
        println(PROGRESS_RESULT_MESSAGE);
        StringBuilder resultBuilder = new StringBuilder();
        for (String result : results) {
            resultBuilder.append(result).append(DOUBLE_LINE_BREAKER);
        }
        println(resultBuilder.toString());
    }

    @Override
    public void printWinners(String winnersName) {
        println(WINNER_RESULT_PREFIX + winnersName);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
