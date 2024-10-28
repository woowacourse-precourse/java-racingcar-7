package racingcar;

public class RacingApplication {

    private InputView inputView;
    private OutputView outputView;
    private RacingController racingController;

    public RacingApplication() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingController = new RacingController(outputView,
                new RacingService(
                        new CarCollectionFactory(
                                new SimpleDelimiterProcessor(),
                                new RandomCarFactory()
                        )
                )
        );
    }

    public void run() {
        ConsoleInput consoleInput = inputView.ask();
        racingController.run(consoleInput);
    }
}
