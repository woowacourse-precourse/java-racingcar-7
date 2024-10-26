package racingcar.io.constant;

public final class ErrorMessage {

    public static final String INVALID_USER_INPUT_MESSAGE = "빈 문자열을 입력할 수 없습니다.";
    public static final String INVALID_TRY_COUNT_MESSAGE = "시도 횟수는 1 부터 2147483647 까지의 정수값만 입력할 수 있습니다.";
    public static final String NOT_POSITIVE_NUMBER_ERROR_MESSAGE = "시도 횟수는 양수만 입력 가능합니다.";
    public static final String GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ATTEMPT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private ErrorMessage() {
    }
}
