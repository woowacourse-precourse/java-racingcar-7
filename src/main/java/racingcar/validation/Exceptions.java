package racingcar.validation;

public enum Exceptions {
    /**
     * Cars 관련 예외
     */
    DUPLICATED_CAR_NAME("대소문자 구분 없이 중복되지 않은 이름을 입력해주세요."),
    INSUFFICIENT_CARS("2개 이상의 차 이름을 입력해주세요."),
    /**
     * MoveNumber 관련 예외
     */
    MOVE_NUMBER_NOT_INTEGER("정수로 된 이동 횟수를 입력해주세요."),
    INSUFFICIENT_MOVE_NUMBER("1회 이상의 이동 횟수를 입력해주세요."),
    /**
     * Car 관련 예외
     */
    BLANK_CAR_NAME("이름으로 공백이나 빈 칸은 허용하지 않습니다."),
    INSUFFICIENT_CAR_NAME_LENGTH("이름은 5자리 이하로 입력해주세요."),
    ;

    private final String msg;

    Exceptions(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
