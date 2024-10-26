package racingcar.util;

import java.util.List;

public class CarNameUtils {

    private CarNameUtils() {
    }

    // 쉼표로 구분된 문자열을 리스트로 변환
    public static List<String> splitCarNames(String carNames) {
        return List.of(carNames.split(","));
    }

}
