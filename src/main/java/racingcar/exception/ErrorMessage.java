package racingcar.exception;

public enum ErrorMessage {
    EMPTY_INPUT("입력값이 비어 있습니다."),

    RANDOM_NUMBER_GENERATOR_NULL_VALUE("생성된 값은 null일 수 없습니다."),
    RANDOM_NUMBER_GENERATOR_OUT_OF_RANGE("생성된 값은 0에서 9 사이의 정수여야 합니다."),

    MOVEMENT_VALUE_NULL("값이 null일 수 없습니다."),
    MOVEMENT_VALUE_OUT_OF_RANGE("값은 0에서 9 사이의 정수여야 합니다."),

    RACING_CAR_MINIMUM_TWO_REQUIRED("경주할 자동차는 2대 이상이어야 합니다."),
    RACING_CAR_NAME_MUST_BE_ENGLISH_OR_KOREAN("자동차 이름은 영어 또는 한글로만 이루어져야 합니다."),
    RACING_CAR_NAME_MAX_LENGTH_EXCEEDED("자동차 이름은 5자 이하이어야 합니다."),

    ATTEMPT_COUNT_MUST_BE_NUMERIC("시도할 횟수는 숫자를 입력하셔야 합니다."),
    ATTEMPT_COUNT_OUT_OF_RANGE("시도할 횟수는 1 이상 20 이하의 정수를 입력하셔야 합니다."),

    RACE_PROGRESS_MANAGER_CAR_NOT_FOUND("해당 자동차를 찾을 수 없습니다."),
    RACE_PROGRESS_MANAGER_DUPLICATE_CAR_NAME("자동차 이름은 중복될 수 없습니다."),

    MOVEMENT_POLICY_NULL("MovementPolicy는 null이 아닌 유효한 객체여야 합니다."),
    RACE_PROGRESS_MANAGER_NULL("RaceProgressManager는 null이 아닌 유효한 객체여야 합니다."),

    RACE_RESULT_EMPTY("경주 결과에 진행 상황이 없어 우승자를 결정할 수 없습니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
