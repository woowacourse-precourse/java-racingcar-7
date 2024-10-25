package racingcar.view;

public class OutputView {

    private static final String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public void requestCarNames() {
        System.out.println(REQUEST_CAR_NAMES_MESSAGE);
    }

    public void requestTryCount() {
        System.out.println(REQUEST_TRY_COUNT_MESSAGE);
    }
}
