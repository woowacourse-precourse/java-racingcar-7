package racingcar;

public class RacingController {
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController(OutputView outputView, RacingService racingService) {
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void run(ConsoleInput consoleInput) {
        racingService.start(consoleInput, outputView);
    }
}
