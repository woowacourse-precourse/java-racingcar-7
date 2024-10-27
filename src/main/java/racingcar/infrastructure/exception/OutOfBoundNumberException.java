package racingcar.infrastructure.exception;

import racingcar.application.constant.InputNumberBoundary;

public class OutOfBoundNumberException extends IllegalArgumentException {
    public OutOfBoundNumberException() {
        super(String.format("숫자는 최대 %d 까지 입력할 수 있습니다.", InputNumberBoundary.REPEAT_MAX));
    }
}
