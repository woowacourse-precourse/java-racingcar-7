package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;

public final class InputHandler {
    private InputHandler() {
    }

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] rawNames = readLine().split(",");

        return Arrays.stream(rawNames) // 한번에 trim 함으로써 중복 제거
                .map(String::trim)
                .toArray(String[]::new);
    }

    public static int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputAttempt = readLine();
        System.out.println();

        if (inputAttempt == null) {
            throw new IllegalArgumentException("시도 횟수를 입력해야 합니다.");
        }

        try {
            return Integer.parseInt(inputAttempt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다. " + e);
        }
    }
}
