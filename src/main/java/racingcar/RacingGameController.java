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
        int tryCount = input.readTryCount();
        RacingGame game = new RacingGame(cars, new RandomMoveCondition(), tryCount);

        output.printGameStart();
        output.printRacingProgress(game, cars);

        List<String> winners = game.determineWinners(game.getPositions());
        output.printWinner(winners);
    }

    private Cars createRacingCars() {
        String carNamesString = input.readCarNames();
        Cars cars = new Cars();
        Set<String> distinctNames = new HashSet<>();
        String[] carNames= carNamesString.split(",");
        for (String carName : carNames) {
            if (isDuplicate(carName, distinctNames)) {
                throw new IllegalArgumentException(String.format("중복된 참가자(%s)가 존재합니다.", carName));
            }
        }
        cars.init(carNames);
        return cars;
    }

    private boolean isDuplicate(String name, Set<String> distinctNames) {
        return !distinctNames.add(name);
    }
}
