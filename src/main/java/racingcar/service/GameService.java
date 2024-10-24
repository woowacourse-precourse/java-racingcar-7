package racingcar.service;

import static java.util.Comparator.*;
import static racingcar.util.ConstNumber.CAR_IS_NOT_STARTED_YET;
import static racingcar.util.ConstNumber.CAR_MOVE_CONDITION;
import static racingcar.util.ConstNumber.RANDOM_NUMBER_END_WITH;
import static racingcar.util.ConstNumber.RANDOM_NUMBER_START_WITH;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.TheCarDoesntStartException;
import racingcar.model.Car;

import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
    // TODO : 상수화 리팩토링
    public boolean isMoving() {
        int carCondition = randomNumber();
        return carCondition >= CAR_MOVE_CONDITION.getValue();
    }

    private int randomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_START_WITH.getValue(), RANDOM_NUMBER_END_WITH.getValue());
    }

    public List<Car> raceResult(List<Car> cars) {
        List<Car> winners = new ArrayList<>(cars);
        winners.sort(comparingInt(Car::getDistance).reversed());

        int winningScore = winners.getFirst().getDistance();
        isRaceStarted(winningScore);

        return winners.stream().filter(c -> c.getDistance() == winningScore).toList();
    }

    private boolean isRaceStarted(Integer winningScore) {
        if(winningScore == CAR_IS_NOT_STARTED_YET.getValue()) {
            throw new TheCarDoesntStartException();
        }
        return true;
    }
}
