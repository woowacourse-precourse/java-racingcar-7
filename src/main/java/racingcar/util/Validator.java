package racingcar.util;

import java.util.List;

/**
 * 입력값을 검증하는 유틸리티 클래스
 */
public class Validator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private Validator() {
    }

    /**
     * 자동차 이름이 비어있지 않으며, 최대 길이를 초과하지 않는지 검증한다.
     *
     * @param carNames 자동차 이름 리스트
     * @throws IllegalArgumentException 유효하지 않은 경우 예외 발생
     */
    public static void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            if (carName == null || carName.trim().isEmpty() || carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME);
            }
        }
    }

    /**
     * 입력된 라운드 수가 양의 정수인지 검증한다.
     *
     * @param inputRound 라운드 입력값
     * @throws IllegalArgumentException 유효하지 않은 경우 예외 발생
     */
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
