package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

public class CarNameInputProcessor {
    private final String carNames;

    public CarNameInputProcessor(String carNames) {
        this.carNames = carNames;
        validateInput();
    }

    public List<String> splitCarNames() {
        List<String> result = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            carName = carName.trim();
            if (result.contains(carName)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
            result.add(carName);
        }

        return result;
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
