package racingcar.utils;

/**
 * 입출력 관련 메시지 관련 클래스
 */
public enum IOMessage {

    ENTER_CAR_NAMES("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)"),
    ENTER_RACING_CHANCE("시도할 횟수는 몇 회인가요?"),
    WINNER_ANNOUNCEMENT("최종 우승자 : "),
    RACING_START("실행 결과");

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}
