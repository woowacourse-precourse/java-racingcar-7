package racingcar.util;

import static racingcar.util.Constants.*;

/**
 * TrialValidator 클래스는 경주 게임에서 사용자가 입력한 시도 횟수의 유효성을 검증하고, 정수 값으로 변환하는 역할을 한다.
 */
public class TrialValidator {

    /**
     * 시도 횟수를 나타내는 문자열 입력값을 검증하고 정수로 반환한다.
     * 입력값이 null, 빈 문자열, 음수, 또는 0 이하일 경우 예외를 발생시킨다.
     *
     * @param input 문자열 형식의 시도 횟수
     * @return 유효한 시도 횟수로 변환된 정수 값
     * @throws IllegalArgumentException 입력값이 null, 빈 문자열이거나, 유효하지 않은 숫자일 경우 발생
     */
    public static int validateTrial(String input) {
        int trial;

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_TRIAL_ERROR);
        }

        try {
            trial = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_TRIAL_ERROR);
        }

        if (trial <= 0) {
            throw new IllegalArgumentException(INVALID_TRIAL_ERROR);
        }

        return trial;
    }
}
