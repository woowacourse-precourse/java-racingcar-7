package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.CarGroup;
import racingcar.domain.car.CarInfo;
import racingcar.utils.NumberGenerator;

public class GameManager {

    private final GameRule gameRule;
    private final NumberGenerator numberGenerator;
    private final WinnerCalculator winnerCalculator;

    public GameManager(GameRule gameRule, NumberGenerator numberGenerator, WinnerCalculator winnerCalculator) {
        this.gameRule = gameRule;
        this.numberGenerator = numberGenerator;
        this.winnerCalculator = winnerCalculator;
    }

    public void moveCarsBasedOnRule(CarGroup carGroup) {
        carGroup.accelerateCars(car -> gameRule.moveCondition(numberGenerator.generator()));
    }

    public List<CarInfo> retrieveCarStatus(CarGroup carGroup) {
        return carGroup.getCarInfos();
    }

    public List<String> determineWinners(CarGroup carGroup) {
        return winnerCalculator.getWinnerNames(carGroup.getCarInfos());
    }
}
