package racingcar.view;

public enum Output {
    INPUT_CARS("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_COUNT("시도할 횟수는 몇 회인가요?"),

    RESULT_HEADER("실행 결과"),
    RESULT_DELIMITER(" : "),
    RESULT_POSITION("-"),

    WINNER("최종 우승자 : "),
    WINNER_DELIMITER(", "),

    NEW_LINE(System.lineSeparator());

    final String message;

    Output(String message) {
        this.message = message;
    }
}
