package racingcar.handler;

public class PrintHandler {
    private static final String RACING_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public void racingStartMessage() {
        System.out.println(RACING_START_MESSAGE);
    }

    public void racingNumberMessage() {
        System.out.println(RACING_NUMBER_MESSAGE);
    }
}