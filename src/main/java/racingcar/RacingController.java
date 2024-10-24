package racingcar;

public class RacingController {
    private final RacingInputView inputView;

    public RacingController(RacingInputView inputView) {
        this.inputView = inputView;
    }

    public String[] SplitCarNames(String RacingCarNames) {
        return RacingCarNames.split(",");
    }

}
