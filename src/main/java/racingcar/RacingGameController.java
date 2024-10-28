package racingcar;

public class RacingGameController implements GameInputView {
    private final RacingGameInputConsole inputView;

    public RacingGameController() {
        this.inputView = new RacingGameInputConsole();
    }

    @Override
    public void start() {
        Game game = createGame();
        game.play();
    }

    private Game createGame() {
        String carNames = inputView.readCarsInput();
        Cars cars = Cars.createCarsFrom(carNames);

        String tryCountInput = inputView.readTryCountInput();
        RacingGameCount count = new RacingGameCount(tryCountInput);

        GameResultOutput resultView = new RacingGameResultOutPut();
        return new RacingGame(cars, count, resultView);
    }
}
