package racingcar.controller;

import racingcar.io.Input;
import racingcar.io.Output;

public class RacingcarController {
    private final Output output;
    private final Input input;

    public RacingcarController(Output output, Input input) {
        this.output = output;
        this.input = input;
    }

    public void playRacingcarGame() {
        output.printCarNameInputPrompt();
        String carName = input.inputString();
    }
}
