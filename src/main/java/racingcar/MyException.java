package racingcar;

public enum MyException {
    INVALID_CAR_NAME("유효하지 않은 자동차 이름입니다.", IllegalArgumentException.class),
    INVALID_MOVE_COUNT("유효하지 않은 시도 횟수입니다.", IllegalArgumentException.class);

    private final String message;
    private final Class<? extends RuntimeException> exception;

    MyException(String message, Class<? extends RuntimeException> exception) {
        this.message = message;
        this.exception = exception;
    }

    public RuntimeException getException() {
        try {
            return exception.getDeclaredConstructor(String.class).newInstance(message);
        } catch (ReflectiveOperationException ignore) {
            return new RuntimeException("프로그램에 문제가 발생했습니다.");
        }
    }
}
