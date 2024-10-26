package racingcar.io;

import racingcar.util.Constants;

public class Output {
    private static final Output instance = new Output();

    private Output() {}

    public static Output getInstance() {
        return instance;
    }

    public void printCarNameInputPrompt() {
        System.out.println(Constants.CAR_NAME_INPUT_PROMPT);
    }
}
