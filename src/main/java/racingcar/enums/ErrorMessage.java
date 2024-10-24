package racingcar.enums;

public enum ErrorMessage {
    ONLY_COMMA("자동차의 이름은 쉼표(,)를 기준으로 구분해야 합니다."),
    NOT_ALLOW_FRONT_COMMA("입력의 시작이 쉼표(,)가 될 수 없습니다."),
    NOT_ALLOW_BACK_COMMA("입력의 마지막이 쉽표(,)가 될 수 없습니다."),
    NOT_ALLOW_NULL("아무런 값도 입력되지 않았습니다."),
    NAME_LENGTH_ONE_TO_FIVE("자동차의 이름은 1~5자리로 입력을 허용합니다."),
    NOT_ALLOW_NAME_DUPLICATION("중복되는 자동차 이름은 입력할 수 없습니다."),
    NOT_ALLOW_BLANK("자동차 이름은 필수로 입력해야 합니다."),
    MIN_CAR_COUNT("경기에 참여하는 자동차는 최소 2대 이상이어야 합니다."),
    CAR_NAME_CONDITION("자동차 이름은 영어, 한글, 숫자, 공백을 허용합니다."),
    TRY_COUNT_UNDER_ONE("경주 횟수는 1 이상의 수를 입력해주세요."),
    NOT_ALLOW_TRY_COUNT_BLANK("경주 횟수가 입력되지 않았습니다."),
    NOT_ALLOW_TRY_COUNT_WITHOUT_NUM("경주 횟수는 숫자를 제회한 문자를 허용하지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
