package racingcar.racing.model;

import java.util.List;
import racingcar.racing.view.OutputView;

public class Game {
    private final int allRound;
    private final List<Car> participant;

    public Game(int allRound, List<Car> cars) {
        this.allRound = allRound;
        this.participant = cars;
    }

    private void roundStart(List<Car> cars) {
        for (Car car : cars) {
            if (car.movedDistance() >= 4) {
                car.updateTotalDistance();
            }
        }
    }

    public void allRoundStart() {
        for (int i = 0; i < allRound; i++) {
            roundStart(participant);
            OutputView.printRoundResult(participant);
        }
    }

    public List<Car> selectWinners() {
        return null;
    }
}
