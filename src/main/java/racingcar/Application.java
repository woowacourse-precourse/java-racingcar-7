package racingcar;

import racingcar.controller.RacingController;
import racingcar.impl.InputParserImpl;
import racingcar.impl.RaceOrNotImpl;
import racingcar.impl.RaceProcessImpl;
import racingcar.model.InputParser;
import racingcar.model.RaceOrNot;
import racingcar.model.RaceProcess;
import racingcar.view.InputHandler;
import racingcar.view.OutputHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        InputParser inputParser = new InputParserImpl();
        RaceOrNot raceOrNot = new RaceOrNotImpl();

        RaceProcess raceProcess = new RaceProcessImpl(inputParser, raceOrNot);

        RacingController racingController = new RacingController(inputHandler, outputHandler, raceProcess);
        racingController.run();
    }
}
