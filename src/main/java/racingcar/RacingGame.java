package racingcar;

public class RacingGame implements Game{
    private final Cars cars;
    private final RacingGameCount racingCount;
    private final GameResultView resultView;

    public RacingGame(Cars cars, RacingGameCount racingCount, GameResultView gameResultView) {
        this.cars = cars;
        this.racingCount = racingCount;
        this.resultView = gameResultView;
    }

    @Override
    public void play() {
        int totalTries = racingCount.getTryCountValue();

        for (int i = 0; i < totalTries; i++) {
            playOneRound();
        }
    }

    private void playOneRound() {
        cars.pickRandomNumberAndMoveCar();
        resultView.printRoundResult();
    }
}
