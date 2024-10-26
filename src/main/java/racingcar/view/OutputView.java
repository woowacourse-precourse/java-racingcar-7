package racingcar.view;

public class OutputView {
    private static final String ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_ATTEMPT = "시도할 횟수는 몃 회인가요?";

    public void askCarName() {
        System.out.println(ASK_CAR_NAME);
    }

    public void askAttempt() {
        System.out.println(ASK_ATTEMPT);
    }

    public void printMiddleResult(StringBuilder middleResult) {
        System.out.println(middleResult);
    }
}