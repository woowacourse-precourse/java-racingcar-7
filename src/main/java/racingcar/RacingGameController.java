package racingcar;

import java.util.List;

public class RacingGameController {

    private final RacingGameInput input;
    private final RacingGameOutput output;

    public RacingGameController(RacingGameInput input, RacingGameOutput output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        Cars cars = createRacingCars();
        RacingGame game = new RacingGame(cars, new RandomMoveCondition());

        int tryCount = input.readTryCount();
        output.printGameStart();
        output.printRacingProgress(game, cars, tryCount);

        List<String> winners = game.getWinners(game.getPositions());
        output.printWinner(winners);
    }

    public Cars createRacingCars() {
        List<String> carNames = input.readCarNames();
        return Cars.withNames(carNames);
    }
}
