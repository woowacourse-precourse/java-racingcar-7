package racingcar.common;

public enum IOMessage {

    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ROUND_COUNT("시도할 횟수는 몇 회인가요?"),
    RESULT_NOTICE("실행 결과"),
    WINNER_ANNOUNCEMENT("최종 우승자 : "),
    CAR_POSITION_FORMAT("%s : %s");

    private final String text;

    IOMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
