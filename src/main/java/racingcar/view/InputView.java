package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Validator.InputValidator;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InputView {
    private static final String MESSAGE = "입력이 잘못되었습니다";

    public static String readString() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputString = Console.readLine();
        validateCarNames(inputString);
        return trimInput(inputString);
    }

    public static int readNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputNum = Console.readLine();
        validateNumber(inputNum);
        System.out.println("");
        return Integer.parseInt(inputNum);
    }

    private static void validateCarNames(String inputString) {
        InputValidator.checkEmptyInput(inputString);
        String trimmedInput = trimInput(inputString);
        if (!InputValidator.checkInputFormat(trimmedInput) || !InputValidator.checkInputRule(trimmedInput)) {
            throw new IllegalArgumentException(MESSAGE);
        }
    }

    private static void validateNumber(String inputNum) {
        if (!InputValidator.isNumber(inputNum)) {
            throw new IllegalArgumentException(MESSAGE);
        }
    }

    private static String trimInput(String input) {
        return Arrays.stream(input.split(",", -1))
                .map(String::trim)
                .collect(Collectors.joining(","));
    }
}
