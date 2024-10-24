package racingcar;

public class RacingController {
    private final RacingInputView inputView;

    public RacingController(RacingInputView inputView) {
        this.inputView = inputView;
    }
    public String[] SplitCarNames(String RacingCarNames) {
        return RacingCarNames.split(",");
    }
    private String[] trimCarNames(String[] carNames) {
        String[] trimNames = new String[carNames.length];
        for(int i = 0 ; i < carNames.length ;i++) {
            trimNames[i] = carNames[i].trim();
        }
        return trimNames;
    }
}
