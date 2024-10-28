package racingcar.utils;

import java.util.*;
import java.util.stream.Collectors;

public class CarNameInputProcessor {

    private CarNameInputProcessor() {
    }

    public static List<String> splitCarNames(String carNames) {
        validateInput(carNames);
        return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static void validateInput(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("공백이나 빈 문자열은 허용하지 않습니다.");
        }
        if (carNames.trim().startsWith(",") || carNames.trim().endsWith(",")) {
            throw new IllegalArgumentException("입력 값의 맨 앞이나 맨 뒤에 쉼표가 올 수 없습니다.");
        }
    }
}
