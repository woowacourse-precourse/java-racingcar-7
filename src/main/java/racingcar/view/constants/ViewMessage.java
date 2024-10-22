package racingcar.view.constants;

public enum ViewMessage {

    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ROUND("시도할 횟수는 몇 회인가요?"),
    RACE_RESULT_TITLE("실행 결과"),
    RACE_STATUS("%s : %s"),
    OUTPUT_RESULT("최종 우승자 : %s"),
    ;

    private final String message;

    ViewMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
