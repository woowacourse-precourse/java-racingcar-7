package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class InputUtil {
    public List<String> convertToList(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

    public void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름이 5자를 초과합니다.");
        }
    }

    public int convertToInt(String attempts) {
        try {
            return Integer.parseInt(attempts);
        } catch (Exception e) {
            throw new IllegalArgumentException("시도할 횟수가 정수가 아닙니다.");
        }
    }
}
