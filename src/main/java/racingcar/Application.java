package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.model.CarMover;
import racingcar.view.CarNameInputValidator;
import racingcar.view.MoveCountInputValidator;

public class Application {
    public static void main(String[] args) {
        CarNameInputValidator carNameInputValidator = new CarNameInputValidator();
        MoveCountInputValidator moveCountInputValidator = new MoveCountInputValidator();
        CarMover carMover = new CarMover();

        RacingCarController racingCarController = new RacingCarController(carNameInputValidator, moveCountInputValidator, carMover);
        racingCarController.startRace();
    }
}
