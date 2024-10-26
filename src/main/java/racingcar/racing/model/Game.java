package racingcar.racing.model;

import java.util.List;
import racingcar.racing.view.OutputView;

public class Game {
    private int currentRound;
    private final int allRound;

    public Game(int allRound) {
        this.currentRound = 0;
        this.allRound = allRound;
    }

    private void roundStart(List<Car> cars) {
        currentRound += 1;
        for (Car car : cars) {
            if (car.movedDistance() >= 4) {
                car.updateTotalDistance();
            }
        }
    }

    public void allRoundStart() {
        for (int i = 0; i < allRound; i++) {
            roundStart(cars);
            OutputView.printRoundResult(cars);
        }
    }
}
