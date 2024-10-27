package racingcar.io.view;

public class RaceInputView implements InputView {
    private static final RaceInputView INSTANCE = new RaceInputView();

    private RaceInputView() {

    }

    public static RaceInputView getInstance() {
        return INSTANCE;
    }

    @Override
    public void showCarNameExplanation() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void showAttemptExplanation() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }
}
