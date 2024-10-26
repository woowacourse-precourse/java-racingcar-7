package racingcar.racing.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.IOException;

public class InputView {
    public static String inputConsole() {
        try {
            return Console.readLine().replace(" ", "");
        } catch (Exception e) {
            throw new IllegalArgumentException("알 수 없는 오류가 발생했습니다. 올바른 값을 입력해주세요.");
        }
    }
}
