package racingcar.io;

import static racingcar.messages.InputMessages.INPUT_CAR_NAMES;
import static racingcar.messages.InputMessages.INPUT_NUMBER_OF_ROUNDS;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private final InputValidator inputValidator = new InputValidator();
    private final InputParser inputParser = new InputParser();

    public String[] inputCarNamesProcess() {
        Output.printMessage(INPUT_CAR_NAMES.getMessages());
        String[] carNames = inputParser.parseCarNames(readInput());
        inputValidator.validateCarNames(carNames);
        return carNames;
    }

    public int inputNumberOfRoundProcess() {
        Output.printMessage(INPUT_NUMBER_OF_ROUNDS.getMessages());
        String numberOfRoundInput = readInput();
        inputValidator.validateNumberOfRound(numberOfRoundInput);
        return Integer.parseInt(numberOfRoundInput);
    }

    private String readInput() {
        return Console.readLine();
    }

    public void closeConsole() {
        Console.close();
    }
}
