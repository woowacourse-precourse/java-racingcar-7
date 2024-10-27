package racingcar.service;

import static java.util.Comparator.*;
import static racingcar.util.constant.MoveCarNumberConstant.CAR_IS_NOT_STARTED_YET;
import static racingcar.util.constant.MoveCarNumberConstant.CAR_MOVE_CONDITION;
import static racingcar.util.constant.MoveCarNumberConstant.RANDOM_NUMBER_END_WITH;
import static racingcar.util.constant.MoveCarNumberConstant.RANDOM_NUMBER_START_WITH;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.TheCarDoesntStartException;
import racingcar.model.Car;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {

    public boolean isMoving() {
        final int carCondition = randomNumber();
        return carCondition >= CAR_MOVE_CONDITION.getValue();
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_START_WITH.getValue(), RANDOM_NUMBER_END_WITH.getValue());
    }

    public List<Car> winners(List<Car> cars) {
        List<Car> sortedResult = sortResultsDescendingOrder(cars);

        final int winningScore = sortedResult.getFirst().getDistance();
        isValidRaceResult(winningScore);

        return sortedResult.stream().filter(c -> c.getDistance() == winningScore).toList();
    }

    private List<Car> sortResultsDescendingOrder(List<Car> results) {
        // results 리스트는 불변리스트여서 복사하여 새로운 리스트를 만듦
        List<Car> newResults = new ArrayList<>(results);
        newResults.sort(comparingInt(Car::getDistance).reversed());
        return newResults;
    }

    private boolean isValidRaceResult(final int winningScore) {
        if(winningScore == CAR_IS_NOT_STARTED_YET.getValue()) {
            throw new TheCarDoesntStartException();
        }
        return true;
    }
}
