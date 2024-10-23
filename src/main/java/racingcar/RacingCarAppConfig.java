package racingcar;

import io.input.Input;
import io.input.impl.InputConsole;
import io.output.Output;
import io.output.impl.OutputConsole;

public class RacingCarAppConfig {

    public RaceGameService raceGame() {
        return new RaceGameService(input(), output());
    }

    public Input input() {
        return new InputConsole();
    }

    public Output output() {
        return new OutputConsole();
    }
}

