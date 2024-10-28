package racingcar;


public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingService = new RacingService();
    }

    public void run() {
        ConsoleInput consoleInput = inputView.ask();
        racingService.start(consoleInput);
    }
}
