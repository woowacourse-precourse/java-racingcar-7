package racingcar;

import java.util.List;

public class GameController {
    private final Racing racing;

    public GameController(Racing racing) {
        this.racing = racing;
    }

    public void run(int round) {
        System.out.println("실행 결과");
        while (round-- > 0) {
            racing.runRound();
            OutputView.printDistance(racing.getCarList());
        }
        List<Car> winner = racing.getWinner();
        OutputView.printWinner(winner);
    }
}
