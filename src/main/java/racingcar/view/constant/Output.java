package racingcar.view.constant;

public enum Output {

    RESULT("실행 결과"),
    CAR_POSITION_FORMAT("%s : %s"),
    SEPARATOR_BLANK_LINES("\n"),
    WINNER_FORMAT("최종 우승자 : %s");

    private final String output;

    Output(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return output;
    }
}
