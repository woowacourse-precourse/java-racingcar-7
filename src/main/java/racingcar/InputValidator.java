package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    private static final int MAX_NAME_LENGTH = 5;

    public static List<String> validateNames(String input) {
        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        // 각 자동차 이름이 5자를 초과하지 않는지 검사
        for (String name : carNames) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
        return carNames;
    }
}