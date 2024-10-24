package racingcar.view;

public class InputView {
    private static final InputView inputView = new InputView();
    private final OutputView outputView;

    private InputView() {
        outputView = OutputView.getInstance();
    }

    public static InputView getInstance() {
        return inputView;
    }
}
