package racingcar.view;

import static racingcar.common.constant.ConsoleMessage.*;
import static racingcar.common.constant.ExceptionMessage.NO_COUNT_NUMBER_FORMAT;
import static racingcar.common.constant.FormatConstants.*;

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
        String inputValue = Console.readLine();
        int number = parseToInt(inputValue);
        validatePositive(number);
        return number;
    }

    @Override
    public void printRacingProgressResult(List<String> results) {
        println(LINE_BREAKER + PROGRESS_RESULT_MESSAGE);
        StringBuilder resultBuilder = new StringBuilder();
        for (String result : results) {
            resultBuilder.append(result).append(DOUBLE_LINE_BREAKER);
        }
        print(resultBuilder.toString());
    }

    @Override
    public void printWinners(String winnersName) {
        println(WINNER_RESULT_PREFIX + winnersName);
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void validatePositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NO_COUNT_NUMBER_FORMAT);
        }
    }

    private int parseToInt(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NO_COUNT_NUMBER_FORMAT);
        }
    }
}
