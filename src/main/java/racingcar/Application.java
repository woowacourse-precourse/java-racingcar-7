package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.MovementFactorGenerator;
import racingcar.model.RandomMovementFactorGenerator;
import racingcar.view.RacingCarView;

public class Application {
    public static void main(String[] args) {
        RacingCarView racingCarView = new RacingCarView();
        MovementFactorGenerator movementFactorGenerator = new RandomMovementFactorGenerator();
        RacingController racingController = new RacingController(racingCarView, movementFactorGenerator);

        racingController.run();
    }
}
