package racingcar.model;

import java.util.List;

public class Verifier {

    public static void verifyCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다. 잘못된 이름: " + carName);
        }
    }

    public static void verifyTryCountRange(Integer tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1번 이상이어야 합니다. 입력 횟수 : " + tryCount);
        }
    }

    public static void verifyNumberOfCar(List<String> input) {
        if (input.isEmpty() || input.size() < 2) {
            throw new IllegalArgumentException("두 개 이상의 자동차 이름을 입력하세요.");
        }
    }
}
