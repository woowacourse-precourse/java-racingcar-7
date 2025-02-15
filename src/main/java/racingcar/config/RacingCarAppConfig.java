package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.io.input.Input;
import racingcar.io.input.impl.InputConsole;
import racingcar.io.output.Output;
import racingcar.io.output.impl.OutputConsole;

public class RacingCarAppConfig {

    public RacingCarController raceGame() {
        return new RacingCarController(input(), output());
    }

    public Input input() {
        return new InputConsole();
    }

    public Output output() {
        return new OutputConsole();
    }
}

