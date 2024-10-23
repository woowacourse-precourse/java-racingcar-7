package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final InputHandler inputHandler;

    public InputView(final InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void readCarNames() {
        final String input = Console.readLine();
        inputHandler.checkEmpty(input);
        inputHandler.validateUniqueNames(input);
    }
}
