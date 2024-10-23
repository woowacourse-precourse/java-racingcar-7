package racingcar.utils;

public class Constant {

    // 입력 요구 메시지
    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ATTEMPT_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    // 에러 메시지
    public static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차의 이름은 5자 이하만 가능합니다.";
    public static final String CAR_NAME_EMPTY_ERROR_MESSAGE = "한 개 이상의 자동차 이름을 입력해야 합니다.";
    public static final String ATTEMPT_COUNT_NUMBER_ERROR_MESSAGE = "시도할 횟수는 1 이상의 정수이어야 합니다.";

    private Constant() {}
}
