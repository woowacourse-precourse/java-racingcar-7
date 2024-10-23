package racingcar;

public class RacingCarController {
    private final OutputView outputView;
    private final InputView inputView;

    private RacingCarService racingCarService;

    public RacingCarController() {
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void start() {
        String readCarNames = getCarNames();
        String readNumberOfAttempts = getNumberOfAttempts();
        racingCarService = new RacingCarService(readCarNames,readNumberOfAttempts);
    }

    private String getNumberOfAttempts() {
        outputView.printReadNumberOfAttempts();
        return inputView.readNumberOfAttempts();
    }

    private String getCarNames() {
        outputView.printReadCarNameMessage();
        return inputView.readCarNames();
    }
}
