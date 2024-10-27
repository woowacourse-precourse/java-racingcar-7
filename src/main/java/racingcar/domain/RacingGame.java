package racingcar.domain;

import java.util.List;

public class RacingGame {

    private final RacingCars racingCars;
    private final MoveCondition moveCondition;
    private int count;

    public RacingGame(List<String> names,MoveCondition moveCondition, int count) {
        this.racingCars = new RacingCars(names);
        this.moveCondition = moveCondition;
        this.count = count;
    }

    public RacingCars playOneTime() {
        racingCars.moveAll(moveCondition);
        count--;
        return racingCars;
    }

    public boolean isPlayable() {
        return count > 0;
    }

    public List<Car> getWinners() {
        return racingCars.getWinners();
    }
}
