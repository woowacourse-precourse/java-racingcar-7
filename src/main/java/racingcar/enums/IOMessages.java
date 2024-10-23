package racingcar.enums;

public enum IOMessages {
    INPUT_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_REPEAT_TIMES("시도할 횟수는 몇 회인가요?"),
    RESULT_HEADER("최종 우승자 :");

    private final String msg;

    IOMessages(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
