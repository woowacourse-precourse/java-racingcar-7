package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return parseAttempts(Console.readLine());
    }

    public static int parseAttempts(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
        }
    }
}
