package racingcar.global.error;

public enum Error {

    NAME_BLANK_EXCEPION("[ERROR] 자동차 이름을 NULL이거나 빈칸으로 할 수 없습니다."),
    NAME_LENGTH_EXCEPION("[ERROR] 자동차 이름의 길이를 5자 초과 할 수 없습니다."),
    NAME_DUPLICATE_EXCEPION("[ERROR] 자동차 이름이 중복 할 수 없습니다."),
    TRY_COUNT_EXCEPION("[ERROR] 시도 횟수는 양의 정수이어야합니다.");

    private String errorMsg;

    Error(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}