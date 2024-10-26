package racingcar.domain;

import racingcar.UI;
import racingcar.Utils;

import java.util.List;

public class RacingGame {
    private final int limit;
    private final List<Car> participants;
    private final Utils utils = new Utils();
    private final UI ui = new UI();

    public RacingGame(int limit, List<Car> participants) {
        this.limit = limit;
        this.participants = participants;
    }

    public void playGame() {
        for (int curr = 0; curr < limit; curr++) {
            playSingleRound();
            if (curr == 0) {
                ui.printRoundResult(true, participants);
                continue;
            }
            ui.printRoundResult(false, participants);
        }
        ui.printWinners(utils.countWinners(participants));
    }

    private void playSingleRound() {
        for (Car car : participants) {
            car.moveOrStop(utils.canMove());
        }
    }
}
