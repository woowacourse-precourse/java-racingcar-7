package racingcar.utils;

public enum ExceptionConstants {

    INVALID_CAR_NAME("자동차 이름은 비어 있을 수 없습니다."),
    CAR_NAME_TOO_LONG("자동차 이름은 5자를 초과할 수 없습니다."),
    INVALID_ROUND_COUNT("라운드 수는 1 이상이어야 합니다."),
    EXCEEDS_MAX_ROUNDS("라운드 수는 최대 100까지 설정 가능합니다."),
    INVALID_ROUND_NUMBER("라운드 수는 숫자로 입력 해주세요."),
    NO_PARTICIPANTS("참가자가 없습니다."),
    EMPTY_INPUT("입력은 비어 있을 수 없습니다."),
    DUPLICATE_CAR_NAME("자동차의 이름은 중복될 수 없습니다."),
    EXCEEDS_MAX_CAR_LIMIT("자동차는 최대 20대 출전할 수 있습니다.");

    private final String errorMessage;

    ExceptionConstants(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
