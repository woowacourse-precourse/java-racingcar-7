package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputHandler {
    public static List<String> getCarsName() {
        String input = Console.readLine();
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없다.");
        }
        List<String> carNames = List.of(input.split(","));
        CarNameValidator.validate(carNames);  // 이름 유효성 검사
        return carNames;
    }

    public static int getAttemptCount() {
        String input = Console.readLine();
        return AttemptValidator.validate(input);
    }
}
