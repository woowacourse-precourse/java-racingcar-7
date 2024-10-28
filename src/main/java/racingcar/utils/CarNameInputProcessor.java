package racingcar.utils;

import java.util.*;
import java.util.stream.Collectors;

public class CarNameInputProcessor {
    private final String carNames;

    public CarNameInputProcessor(String carNames) {
        this.carNames = carNames;
        validateInput();
    }

    public List<String> splitCarNames() {
        return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateInput() {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("공백이나 빈 문자열은 허용하지 않습니다.");
        }
        if (carNames.trim().startsWith(",") || carNames.trim().endsWith(",")) {
            throw new IllegalArgumentException("입력 값의 맨 앞이나 맨 뒤에 쉼표가 올 수 없습니다.");
        }
    }
}
