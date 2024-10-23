package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public final class InputHandler {
    private InputHandler() {
    }

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return readLine().split(",");
    }

    public static int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputAttempt = readLine();
        System.out.println();
        try {
            return Integer.parseInt(inputAttempt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다." + e);
        }
    }
}
