package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.model.RacingCarRepository;
import racingcar.validator.Validator;
import racingcar.view.RacingCarIO;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        RacingCarIO racingCarIO = new RacingCarIO();
        RacingCarRepository raceRepository = new RacingCarRepository();
        Validator validator = new Validator();
        RacingCarController racingCarController = new RacingCarController(racingCarIO, raceRepository, validator);

        racingCarController.getCarList();
        racingCarController.getTryCount();
        racingCarController.calculateRandomNumber();
        racingCarController.calculateWinner();
    }
}
