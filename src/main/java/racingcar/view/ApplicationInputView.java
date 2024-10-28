package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ApplicationInputView {
    public static String input() {
        return Console.readLine();
    }

    public static int getInt() {
        try {
            return Integer.parseInt(input());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("범위 외의 입력이 들어왔거나, 정수가 아닌 값이 입력 되었습니다.");
        }
    }
}
