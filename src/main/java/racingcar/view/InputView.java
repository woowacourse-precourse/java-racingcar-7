package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {

    private static final Pattern VALID_CAR_INPUT_PATTERN = Pattern.compile("[a-zA-Z]{1,5}(,[a-zA-z]{1,5})*");
    private static final Pattern VALID_MOVE_COUNT_INPUT_PATTERN = Pattern.compile("^(0|[1-9][0-9]*)$");

    public static String readLine() {
        return Console.readLine();
    }

    public static List<String> getCarNames() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        if (!isValidCarInput(input)) {
            throw new IllegalArgumentException("자동차 이름 입력이 올바르지 않습니다.");
        }
        return splitCarNamesByComma(input);
    }

    private static List<String> splitCarNamesByComma(String input) {
        return List.of(input.split(","));
    }

    private static boolean isValidCarInput(String input) {
        return VALID_CAR_INPUT_PATTERN.matcher(input).matches();
    }

    public static int getMoveCount() throws IllegalArgumentException {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = readLine();
        if (!isValidMoveCountInput(input)) {
            throw new IllegalArgumentException("이동 횟수 입력이 올바르지 않습니다.");
        }
        return Integer.parseInt(input);
    }

    private static boolean isValidMoveCountInput(String input) {
        return VALID_MOVE_COUNT_INPUT_PATTERN.matcher(input).matches();
    }

}
