package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    private static final String CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT = "시도할 횟수는 몇 회 인가요?";
    private static final String INVALID_INPUT_ERROR = "[ERROR] 숫자를 입력해주세요.";
    private static final String BLANK_ATTEMPTS_ERROR = "[ERROR] 공백은 입력할 수 없습니다.";

    public static void print(String message) {
        System.out.println(message);
    }

    public static List<String> getCarNames() {
        print(CAR_NAME_INPUT);
        List<String> carNames = List.of(Console.readLine().split(","));
        return carNames;
    }

    public static int getAttempts() {
        print(TRY_COUNT_INPUT);
        String tryCount = Console.readLine();
        validateBlankAttempts(tryCount);
        validateInvalidInput(tryCount);
        return Integer.parseInt(tryCount);
    }

    private static void validateBlankAttempts(String tryCount) {
        if (tryCount.isEmpty() || tryCount.isBlank()) {
            throw new IllegalArgumentException(BLANK_ATTEMPTS_ERROR);
        }
    }

    private static void validateInvalidInput(String attempts) {
        try {
            Integer.parseInt(attempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }
}
