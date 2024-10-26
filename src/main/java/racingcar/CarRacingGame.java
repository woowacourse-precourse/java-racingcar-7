package racingcar;

import java.util.List;
import java.util.Arrays;

public class CarRacingGame {
    // 첫 번째 기능: 자동차 이름 입력 및 검증
    public static List<String> getCarNames(String input) {
        List<String> carNames = Arrays.asList(input.split(","));

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }

    // 두 번째 기능: 이동 횟수 입력 및 정수 검증
    public static int getMoveCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(); // 정수 아닌 경우 예외 발생
        }
    }
}
