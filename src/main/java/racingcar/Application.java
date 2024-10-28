package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.model.MovementFactorGenerator;
import racingcar.model.RandomMovementFactorGenerator;
import racingcar.view.RacingCarView;

public class Application {
    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarView();
        MovementFactorGenerator movementFactorGenerator = new RandomMovementFactorGenerator();
        RacingCarController racingCarController = new RacingCarController(racingCarView, movementFactorGenerator);

        racingCarController.run();
    }
}
