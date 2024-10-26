package racingcar.view.io.read;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    // Constructor
    private InputView() {
    }

    private static class InputViewHolder {
        private static final InputView INSTANCE = new InputView();
    }

    // Method
    public static InputView getInstance() {
        return InputViewHolder.INSTANCE;
    }

    public String readInput() {
        return Console.readLine();
    }
}
