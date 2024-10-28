package racingcar;

import racingcar.controller.RacingManager;
import racingcar.input.InputParser;
import racingcar.input.InputReader;
import racingcar.output.OutputViewer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingManager racingManager = new RacingManager(
                new InputReader(new InputParser()),
                new OutputViewer()
        );
        racingManager.run();
    }
}
