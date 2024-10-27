package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Racing;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        Racing racing = new Racing(InputView.readCars());
        int trials = Integer.parseInt(InputView.readTrials());
        GameController gameController = new GameController(racing, trials);
        gameController.run();
    }
}
