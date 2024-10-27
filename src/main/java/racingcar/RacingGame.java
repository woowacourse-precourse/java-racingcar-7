package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame implements Game {
    private final Cars cars;
    private final RacingGameCount racingCount;
    private final GameResultOutput resultView;

    public RacingGame(Cars cars, RacingGameCount racingCount, GameResultOutput gameResultOutput) {
        this.cars = cars;
        this.racingCount = racingCount;
        this.resultView = gameResultOutput;
    }

    @Override
    public void play() {
        int totalTries = racingCount.getTryCountValue();

        for (int i = 0; i < totalTries; i++) {
            playOneRound();
        }
        printWinners();
    }

    private void playOneRound() {
        cars.pickRandomNumberAndMoveCar();
        List<GameRoundResultOutput> roundResults = cars.getCars().stream()
                .map(car -> new RacingRoundResultOutput(car.getName(), car.getPosition()))
                .collect(Collectors.toList());

        resultView.printRoundResult(roundResults);
    }

    private void printWinners() {
        List<String> winners = cars.findWinners();
        resultView.printGameResult(winners);
    }
}
