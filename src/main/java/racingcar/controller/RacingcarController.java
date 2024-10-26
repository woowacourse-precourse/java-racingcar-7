package racingcar.controller;

import racingcar.io.Output;

public class RacingcarController {
    private final Output output;

    public RacingcarController(Output output) {
        this.output = output;
    }

    public void playRacingcarGame() {
        output.printCarNameInputPrompt();

    }
}
