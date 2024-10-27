package racingcar.config;

public class GameErrorMessage {
    private GameErrorMessage() {
        throw new IllegalStateException("Config Class");
    }

    public static final String DUPLICATE_CAR_NAME_MESSAGE = "같은 이름을 가진 자동차가 있습니다.";
    public static final String EMPTY_NAME_MESSAGE = "이름을 1글자 이상 입력해주세요.";
    public static final String LENGTH_EXCEED_MESSAGE = "허용된 이름 길이를 초과했습니다.";
    public static final String INVALID_NAME_FORMAT_MESSAGE = "이름은 공백으로 시작하거나 끝낼 수 없습니다.";
    public static final String NON_NUMERIC_MESSAGE = "숫자를 입력해주세요";
    public static final String NEGATIVE_ATTEMPT_MESSAGE = "0이하의 정수는 입력할 수 없습니다.";
}
