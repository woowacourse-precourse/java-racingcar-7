package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.service.RacingcarService;
import racingcar.service.RacingcarServiceImpl;
import racingcar.util.Validator;

public class Application {
    public static void main(String[] args) {
        Output output = Output.getInstance();
        Input input = Input.getInstance();
        Validator validator = Validator.getInstance();
        RacingcarService racingcarService = RacingcarServiceImpl.getInstance();
        RacingcarController racingcarController = new RacingcarController(output, input, validator, racingcarService);
        racingcarController.playRacingcarGame();
    }
}
