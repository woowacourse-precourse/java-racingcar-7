package racingcar.filter.executor;

import racingcar.model.CarList;

public class RaceExecutor {
    public void executeRace(CarList carList, int iterations) {
        for (int i = 1; i <= iterations; i++) {
            carList.moveAll();
        }
    }
}