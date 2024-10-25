package racingcar.race.exception;

import racingcar.common.ExceptionEnum;

// 시도 횟수 관련 예외 처리 클래스
public class AttemptCountException extends IllegalArgumentException {
    public AttemptCountException(String message) {
        super(message);
    }
}
