package racingcar.exception;

public enum ErrorMessage {
    INPUT_REQUIRED("입력을 반드시 제공해야 합니다."),

    RANDOM_NUMBER_REQUIRED("유효한 랜덤 숫자를 제공해야 합니다."),
    RANDOM_NUMBER_MUST_BE_IN_RANGE("랜덤 숫자는 0에서 9 사이여야 합니다."),

    MINIMUM_TWO_CARS_REQUIRED("경주할 자동차는 최소 2대 이상이어야 합니다."),
    ONLY_ENGLISH_OR_KOREAN_ALLOWED("자동차 이름은 영어 또는 한글로만 구성되어야 합니다."),
    NAME_MAX_LENGTH_LIMIT("자동차 이름은 최대 5자까지 가능합니다."),
    MUST_START_WITH_LETTER("자동차 이름은 문자로 시작해야 합니다. 특수 문자나 숫자로 시작할 수 없습니다."),
    MUST_END_WITH_LETTER("자동차 이름은 문자로 끝나야 합니다. 특수 문자나 숫자로 끝날 수 없습니다."),
    NAME_REQUIRED("자동차 이름이 비어 있지 않아야 합니다. 각 자동차에 유효한 이름을 지정해 주세요."),

    ATTEMPT_COUNT_MUST_BE_NUMERIC("시도 횟수는 숫자로 입력해야 합니다."),
    ATTEMPT_COUNT_MUST_BE_IN_RANGE("시도 횟수는 1에서 20 사이여야 합니다."),

    CAR_MUST_BE_REGISTERED("자동차는 경주에 등록되어 있어야 합니다."),
    UNIQUE_CAR_NAME_REQUIRED("자동차 이름은 고유해야 합니다."),

    POLICY_REQUIRED("MovementPolicy는 유효한 객체여야 합니다."),
    MANAGER_REQUIRED("RaceProgressManager는 유효한 객체여야 합니다."),

    RACE_RESULT_MUST_HAVE_PROGRESS("경주 결과에는 진행 상황이 있어야 합니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
