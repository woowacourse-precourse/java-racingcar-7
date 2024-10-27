package racingcar.car;

import java.util.List;

import static racingcar.constant.Condition.SINGLE_WINNERS;

public class RaceResultJudge {

    public boolean isSingleWinner(List<Car> winningCars) {
        return winningCars.size() == SINGLE_WINNERS.value();
    }


}
