package racingcar.service;

import static racingcar.util.constant.MoveCarNumberConstant.CAR_MOVE_CONDITION;
import static racingcar.util.constant.MoveCarNumberConstant.RANDOM_NUMBER_END_WITH;
import static racingcar.util.constant.MoveCarNumberConstant.RANDOM_NUMBER_START_WITH;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Cars;

public class GameService {

    public boolean isMoving() {
        final int carCondition = randomNumber();
        return carCondition >= CAR_MOVE_CONDITION.getValue();
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_START_WITH.getValue(), RANDOM_NUMBER_END_WITH.getValue());
    }

    public List<String> winners(Cars cars) {
        Cars sortedResult = cars.sortCarsToDescendingOrder();
        Cars winners = sortedResult.findWinners();
        return winners.carsToName();
    }
}
