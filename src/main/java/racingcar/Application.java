package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputReader;
import racingcar.view.OutputWriter;

public class Application {
    public static void main(String[] args) {

        OutputWriter outputWriter = new OutputWriter();
        InputReader inputReader = new InputReader(outputWriter);

        RacingController racingController = new RacingController(inputReader);
        racingController.startRace();

    }
}
