package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Input {

    public static String inputCarName() {
        try {
            String input = Console.readLine();
            if (input == null || input.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }
            return input;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("자동차 이름 입력이 필요합니다.");
        }
    }

    public static int inputTryCount() {
        return Integer.parseInt(Console.readLine());
    }
}
