package racingcar.ui;

public class UiInitializer {

    public OutputController initOutputController() {
        return new OutputController(new OutputConsole());
    }

    public InputController initInputController() {
        return new InputController(new InputConsole());
    }
}
