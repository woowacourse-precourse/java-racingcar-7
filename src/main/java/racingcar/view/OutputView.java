package racingcar.view;

public class OutputView {
    private static final String ASK_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_FOR_TRY_COUNT = "시도할 횟수는 몇 회인가요?";

    public void askForCarNames() {
        System.out.println(ASK_FOR_CAR_NAMES);
    }

    public void askForTryCount() {
        System.out.println(ASK_FOR_TRY_COUNT);
    }
}
