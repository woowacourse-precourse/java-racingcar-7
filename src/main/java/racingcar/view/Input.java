package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String inputCarNames() {
        try {
            return Console.readLine();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    public static int inputAttemptNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해주세요.");
        }
    }

}
