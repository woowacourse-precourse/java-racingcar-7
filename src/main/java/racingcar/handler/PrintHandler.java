package racingcar.handler;

public class PrintHandler {
    private static final String RACING_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public void racingStartMessage() {
        System.out.println(RACING_START_MESSAGE);
    }
}