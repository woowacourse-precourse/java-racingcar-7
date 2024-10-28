package racingcar.constant;

public enum RacingCarInfoMsg {
    TYPE_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TYPE_RACE_COUNT("시도할 횟수는 몇 회인가요?"),
    TRACKING_START("실행 결과"),
    PRESENTATION_FINAL_WINNER("최종 우승자 : ");

    private final String msg;

    RacingCarInfoMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
