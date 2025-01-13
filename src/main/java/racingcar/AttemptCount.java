package racingcar;

import exception.CustomIllegalArgException;

public class AttemptCount {

    public static int from(String inputCount) {
        return validCount(inputCount);
    }

    private static int validCount(String inputCount) {
        try {
            int attemptCount = Integer.parseInt(inputCount);
            if (attemptCount < 1 || attemptCount > 1_000_000_000) {
                throw new IllegalArgumentException("시도 횟수는 1 이상 1,000,000,000 이하의 숫자여야 합니다.");
            }
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new CustomIllegalArgException("숫자만 입력해야 합니다.");
        } catch (IllegalArgumentException e) {
            throw new CustomIllegalArgException(e.getMessage());
        }
    }
}
