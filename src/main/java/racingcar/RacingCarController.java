package racingcar;

public class RacingCarController {
    private final OutputView outputView;

    public RacingCarController() {
        outputView = new OutputView();
    }

    public void start() {
        outputView.printReadCarNameMessage();
    }
}
