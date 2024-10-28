package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CAR_NAME);
        }
        return carNames;
    }

    public static int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return parseAttempts(input);
    }

    private static int parseAttempts(String input) {
        try {
            int attempts = Integer.parseInt(input);
            validateAttempts(attempts);
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_ATTEMPTS);
        }
    }

    private static void validateAttempts(int attempts) {
        if (attempts <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_ATTEMPTS);
        }
    }
}
