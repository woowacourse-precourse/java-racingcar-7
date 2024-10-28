package racingcar;

public class RacingController {
    private final InputView inputView;

    public RacingController() {
        this.inputView = new InputView();
    }

    public void run() {
        inputView.askCarNames();
    }
}
