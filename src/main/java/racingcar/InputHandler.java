package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;

public final class InputHandler {
    private InputHandler() {
    }

    public static String[] getCarNames() {
        String[] rawNames = readLine().split(",");

        return Arrays.stream(rawNames) // 한번에 trim 함으로써 중복 제거
                .map(String::trim)
                .toArray(String[]::new);
    }

    public static int getAttempts() {
        String inputAttempt = readLine().trim();
        System.out.println();

        if (inputAttempt == null) {
            throw new IllegalArgumentException("시도 횟수를 입력해야 합니다.");
        }

        try {
            return Integer.parseInt(inputAttempt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 '한 개'의 '숫자'여야 합니다. ", e);
        }
    }
}
