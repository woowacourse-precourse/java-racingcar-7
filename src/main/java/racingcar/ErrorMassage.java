package racingcar;

public enum ErrorMassage {
    NULL_NAME("공백의 이름이 존재합니다. 올바르게 입력해 주세요"),
    LENGTH_EXCEEDED("5자 이하로 작성해야 합니다."),
    REQUIRED_PLAYER("플레이어가 2명 이상이여야 합니다."),
    DUPLICATE_NAME("이름은 중복될 수 없습니다."),
    INVALIDE_TRY("시도할 횟수는 숫자로만 작성해 주세요"),
    REQUIRED_TRY("1회 이상 시도해야 합니다."),
    INVALID_NAME("이름은 문자나 숫자만 허용됩니다"),
    NO_STARTED("출발한 자동차가 존재하지 않습니다.");

    private final String message;

    ErrorMassage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
