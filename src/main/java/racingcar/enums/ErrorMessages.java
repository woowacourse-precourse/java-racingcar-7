package racingcar.enums;

public enum ErrorMessages {
    INPUT_WHITESPACES("에러: 아무것도 입력하지 않으셨습니다!"),
    NAME_LENGTH_OUT_OF_BOUND("에러: 입력된 이름의 길이가 5를 넘어갑니다. 길이 5이하의 이름을 입력해주세요!"),
    REPEAT_TIMES_NOT_DIGIT("에러: 입력된 반복 횟수에 숫자가 아닌 문자가 포함되어 있습니다!"),
    REPEAT_TIMES_OUT_OF_BOUND("에러: 0 ~ 2,147.483,647 이외의 숫자는 입력하실 수 없습니다!");

    private final String msg;

    ErrorMessages(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
