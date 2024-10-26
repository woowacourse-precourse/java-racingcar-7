package racingcar.controller;

import racingcar.exception.InvalidNameException;
import racingcar.view.InputHandler;
import racingcar.view.OutputHandler;

public class Controller {

    private static final String COMMA = ",";

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Controller(final InputHandler inputHandler, final OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void process(){
        String inputNames = readNames(outputHandler, inputHandler);
        validateInputNames(inputNames);

    }

    private String readNames(OutputHandler outputHandler, InputHandler inputHandler) {
        outputHandler.showCommentForCarNames();
        return inputHandler.read();
    }

    private void validateInputNames(final String value) {
        if (value.endsWith(COMMA)) {
            throw new InvalidNameException("이름은 비어있을 수 없습니다.");
        }
    }
}
