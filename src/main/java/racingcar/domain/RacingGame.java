package racingcar.domain;

import racingcar.view.OutputView;
import racingcar.Utils;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final int limit;
    private final List<Car> participants = new ArrayList<>();
    private final Utils utils;
    private final OutputView outputView;

    public RacingGame(int limit, OutputView outputView, Utils utils) {
        this.limit = limit;
        this.outputView = outputView;
        this.utils = utils;
    }

    public void setParticipants(String[] splited) {
        for (String carName : splited) {
            participants.add(new Car(carName));
        }
    }

    public void playGame() {
        for (int curr = 0; curr < limit; curr++) {
            playSingleRound();
            if (curr == 0) {
                outputView.printRoundResult(true, participants);
                continue;
            }
            outputView.printRoundResult(false, participants);
        }
        outputView.printWinners(utils.countWinners(participants));
    }

    private void playSingleRound() {
        for (Car car : participants) {
            car.moveOrStop(utils.canMove());
        }
    }
}
