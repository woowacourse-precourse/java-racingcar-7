package racingcar.car.exception;

import racingcar.RacingCarException;

public class CarNameException extends RacingCarException {
    public CarNameException(String message){
        super(message);
    }

    public static class NameLengthExceededException extends CarNameException {
        public NameLengthExceededException() {
            super("자동차 이름은 최대 10자까지 가능합니다.");
        }
    }

    public static class EmptyNameException extends CarNameException {
        public EmptyNameException() {
            super("자동차 이름은 최소 1자부터 가능합니다.");
        }
    }
}
