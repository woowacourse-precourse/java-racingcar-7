package racingcar;

import java.util.List;

public class GameController {
    private final Racing racing;
    private final int round;

    public GameController(Racing racing, int round) {
        this.racing = racing;
        this.round = round;
    }

    public void run() {
        OutputView.printRunMessage();
        for (int i = 0; i < round; i++) {
            racing.runRound();
            OutputView.printDistance(racing.getCarList());
        }
        List<Car> winner = racing.getWinner();
        OutputView.printWinner(winner);
    }
}
