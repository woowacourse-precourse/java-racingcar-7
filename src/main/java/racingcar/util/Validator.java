package racingcar.util;

import java.util.List;

public class Validator {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    // 생성자를 private으로 추가해 인스턴스 생성을 방지한다.
    private Validator() {
    }

    public static void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (carName == null || carName.trim().isEmpty() || carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME);
            }
        }
    }

    public static void validateRound(String inputRound) {
        try {
            int round = Integer.parseInt(inputRound);
            if (round <= 0) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_ROUND_COUNT);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NON_NUMERIC_ROUND_COUNT);
        }
    }
}
