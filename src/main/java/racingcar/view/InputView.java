package racingcar.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() { }

    private static class InputViewHolder {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return InputViewHolder.INSTANCE;
    }

    public String getInput() {
        return Console.readLine();
    }
}
