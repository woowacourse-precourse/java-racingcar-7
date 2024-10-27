package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingInfo {
    public static int attempts = ValidateInput.attempts(); // 시도 횟수
    public static List<String> cars = new ArrayList<>(ValidateInput.name()); // 자동차 이름

    public static void initialize() {
        // 유효성 검사 이후 attempts와 cars 초기화
        attempts = ValidateInput.attempts();
        cars = ValidateInput.name();
    }
}
