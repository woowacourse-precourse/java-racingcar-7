package racingcar.config;

public class GameMessage {
    private GameMessage() {
        throw new IllegalStateException("Config Class");
    }

    public static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String REQUEST_ATTEMPT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    public static final String RESULT_NOTIFICATION_MESSAGE = "실행 결과";
    public static final String WINNER_NOTIFICATION_MESSAGE = "최종 우승자 : ";
}
