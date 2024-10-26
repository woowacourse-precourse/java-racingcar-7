package racingcar.view;

public enum Message {
    WINNER_MESSAGE("최종 우승자 : %s"),
    REQUEST_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_TOTAL_TRY_COUNT_MESSAGE("시도할 횟수는 몇 회인가요?"),
    RESULT_TITLE_MESSAGE("실행 결과"),
    RESULT_CAR_MESSAGE("%s : %s"),
    ;

    private final String format;

    Message(String format) {
        this.format = format;
    }

    public void printMessage(String... values) {
        System.out.println(formatWith(values));
    }

    public String formatWith(String... values) {
        return String.format(format, values);
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
