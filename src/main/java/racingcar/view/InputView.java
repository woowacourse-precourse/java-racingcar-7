package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static InputView createInputView() {
        return new InputView();
    }

    public String userInput() {
        return Console.readLine();
    }
}
