package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        List<String> winners = game.determineWinners(game.getPositions());
        output.printWinner(winners);
    }

    private Cars createRacingCars() {
        List<String> carNames = input.readCarNames();
        Set<String> distinctNames = new HashSet<>();
        for (String name : carNames) {
            if (isDuplicate(name, distinctNames)) {
                throw new IllegalArgumentException(String.format("(%s)은 중복된 참가자입니다. 다시 입력해주세요.", name));
            }
        }
        return Cars.withNames(carNames);
    }

    private boolean isDuplicate(String name, Set<String> distinctNames) {
        return !distinctNames.add(name);
    }
}
