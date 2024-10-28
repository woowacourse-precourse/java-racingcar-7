package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.Racing;
import racingcar.domain.Validator;
import racingcar.view.InputReader;
import racingcar.view.OutputWriter;

public class Application {
    public static void main(String[] args) {
        Validator validator = new Validator();
        OutputWriter outputWriter = new OutputWriter();
        Racing racing = new Racing(validator, outputWriter);
        InputReader inputReader = new InputReader(outputWriter, validator);

        RacingController racingController = new RacingController(inputReader, racing, outputWriter);
        racingController.startRace();
    }
}
