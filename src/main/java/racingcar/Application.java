package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Racing;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        Racing racing = Racing.of(InputView.readCars());
        int round = Integer.parseInt(InputView.readTrials());
        GameController gameController = new GameController(racing, round);
        gameController.run();
    }
}
