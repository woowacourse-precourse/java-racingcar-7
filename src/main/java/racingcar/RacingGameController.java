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
        String[] carNames= carNamesString.split(",");
        validate(carNames);
        cars.init(carNames);
        return cars;
    }

    private void validate(String[] carNames) {
        if (carNames.length == 1) {
            throw new IllegalArgumentException("참가자는 쉼표(,)를 기준으로 2명 이상이어야 합니다.");
        }
        Set<String> distinctNames = new HashSet<>();
        for (String carName : carNames) {
            if (isDuplicate(carName, distinctNames)) {
                throw new IllegalArgumentException(String.format("중복된 참가자(%s)가 존재합니다.", carName));
            }
        }
    }

    private boolean isDuplicate(String name, Set<String> distinctNames) {
        return !distinctNames.add(name);
    }
}
