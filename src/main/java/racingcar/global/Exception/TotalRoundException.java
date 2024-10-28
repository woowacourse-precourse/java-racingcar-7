package racingcar.global.Exception;

public class TotalRoundException extends IllegalArgumentException {
    public TotalRoundException(String message) {
        super(message);
    }

    public static class EmptyTotalRoundException extends TotalRoundException {
        public EmptyTotalRoundException() {
            super("시도 횟수로 공백은 불가능합니다.");
        }
    }

    public static class InvalidTotalRoundFormatException extends TotalRoundException {
        public InvalidTotalRoundFormatException() {
            super("시도 횟수는 공백 없는 하나의 자연수만 가능합니다.");
        }
    }

    public static class NonPositiveRoundException extends TotalRoundException {
        public NonPositiveRoundException() {
            super("시도 횟수는 0보다 큰 정수만 가능합니다.");
        }
    }
}
