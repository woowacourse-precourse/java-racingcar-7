package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.CarInfo;
import racingcar.domain.car.Cars;
import racingcar.utils.NumberGenerator;

public class GameManager {

    private final GameRule gameRule;
    private final NumberGenerator numberGenerator;
    private final WinnerDeterminer winnerDeterminer;

    public GameManager(GameRule gameRule, NumberGenerator numberGenerator, WinnerDeterminer winnerDeterminer) {
        this.gameRule = gameRule;
        this.numberGenerator = numberGenerator;
        this.winnerDeterminer = winnerDeterminer;
    }

    public void moveCarsBasedOnRule(Cars cars) {
        cars.accelerateCars(car -> gameRule.moveCondition(numberGenerator.generator()));
    }

    public List<CarInfo> retrieveCarStatus(Cars cars) {
        return cars.getCarInfos();
    }

    public List<String> determineWinners(Cars cars) {
        return winnerDeterminer.getWinnerNames(cars.getCarInfos());
    }
}
