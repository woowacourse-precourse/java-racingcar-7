package racingcar.dto;

import racingcar.exception.ExceptionMessage;

public record RacingInfo(
        String carNames,
        int tryCount
) {
    public RacingInfo {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.TRY_COUNT_IS_ZERO.getErrorMessage());
        }
    }
}
