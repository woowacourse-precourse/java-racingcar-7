package racingcar.racing.model;

import java.util.List;

public class Game {
    private int currentRound;
    private final int allRound;

    public Game(int allRound) {
        this.currentRound = 0;
        this.allRound = allRound;
    }

    public void roundStart(List<Car> cars) {
        currentRound += 1;
        for (Car car : cars) {
            if (car.movedDistance() >= 4) {
                car.updateTotalDistance();
            }
        }
    }

}
