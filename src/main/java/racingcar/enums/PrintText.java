package racingcar.enums;

public enum PrintText {
    CAR_NAME_PROMPT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ATTEMPT_COUNT_PROMPT("시도할 횟수는 몇 회인가요?"),
    MOVE_SYMBOL("-");

    private final String print;

    PrintText(String print) {
        this.print = print;
    }

    public String getPrint() {
        return print;
    }
}
