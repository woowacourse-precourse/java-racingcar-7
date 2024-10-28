package racingcar;

public enum ExceptionCode {

    INPUT_BLANK("입력값이 존재하지 않습니다"),
    CAR_SHORTAGE("차는 최소 2대 이상이어야 합니다"),
    NAME_TOO_LONG("차 이름은 5자를 초과할 수 없습니다"),
    WRONG_NUMBER_FORMAT("시도 횟수 입력이 올바르지 않습니다"),
    SIZE_NOT_MATCHED("자동차 컬렉션의 크기와 난수 컬렉션의 크기가 일치하지 않습니다.");

    final String message;

    ExceptionCode(String message) {
        this.message = message;
    }
}
