package racingcar.view;

public class OutputView {
    private static final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_ROUND = "시도할 회수는 몇 회인가요?";

    public void printRequestCarNames() {
        System.out.println(REQUEST_CAR_NAMES);
    }

    public void printRequestRound() {
        System.out.println(REQUEST_ROUND);
    }
}
