package racingcar.input;

import racingcar.validator.InputValidator;

public class InputHandler {

    private final InputPrompter inputPrompter = new InputPrompter();
    private final InputReceiver inputReceiver = new InputReceiver();
    private final InputValidator inputValidator = new InputValidator();

    public void promptCarNames() {
        inputPrompter.promptCarNames();
    }

    public void promptRaceCount() {
        inputPrompter.promptRaceCount();
    }

    public String receiveCarNames() {
        return inputReceiver.receiveCarNames();
    }

    public long receiveRaceCount() {
        return inputReceiver.receiveRaceCount();
    }

    public void validateInput(String carNames, long raceCount) {
        inputValidator.validateInput(carNames, raceCount);
    }

}
