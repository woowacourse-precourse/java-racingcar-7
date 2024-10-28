package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    public static int getAttemptCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int attemptCount = Integer.parseInt(Console.readLine());
        validateAttemptCount(attemptCount);
        return attemptCount;
    }

    private static void validateAttemptCount(int attemptCount) {
        try {
            if (attemptCount < 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
