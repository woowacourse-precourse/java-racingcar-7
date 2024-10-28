package racingcar;

import java.util.ArrayList;
import java.util.Map;
import racingcar.domain.InputContainer;
import racingcar.repository.RacingCarRepository;
import racingcar.service.RacingCarService;
import racingcar.validator.Validator;
import racingcar.controller.InputController;
import racingcar.controller.OutputController;

public class Application {

    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.start();
    }
}
