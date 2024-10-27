package racingcar.ui;

public class InputController {

    private final InputConsole inputConsole;

    InputController(final InputConsole inputConsole) {
        this.inputConsole = inputConsole;
    }

    public InputCarNames getInputCarNames() {
        return new InputCarNames(inputConsole.readLine());
    }

    public InputGameRoundCount getInputRoundCount() {
        return new InputGameRoundCount(inputConsole.readLine());
    }
}
