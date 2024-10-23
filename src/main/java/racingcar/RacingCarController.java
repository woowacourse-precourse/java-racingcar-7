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
        outputView.printReadCarNameMessage();
        String readLine = inputView.readLine();
        racingCarService = new RacingCarService(readLine);
    }
}
