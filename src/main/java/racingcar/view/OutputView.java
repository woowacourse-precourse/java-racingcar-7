package racingcar.view;

public class OutputView {
    private static final String ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_ATTEMPT = "시도할 횟수는 몃 회인가요?";

    public void askCarName() {
        printMessage(ASK_CAR_NAME);
    }

    public void askAttempt() {
        printMessage(ASK_ATTEMPT);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}