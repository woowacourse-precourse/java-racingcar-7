package racingcar;

public enum ExceptionMessage {
    INPUT_EMPTY("빈 문자열이 입력되었습니다."),
    NAME_EMPTY("입력된 이름 목록에 빈 문자열이 포함되었습니다."),
    NAME_DUPLICATED("입력된 이름 목록에 중복된 자동차 이름이 포함되었습니다."),
    NAME_TOO_LONG("입력된 이름 목록 중 이름 길이가 5글자 초과인 이름이 포함되었습니다."),
    NUM_NOT_NUM("입력된 값은 숫자가 아닙니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
