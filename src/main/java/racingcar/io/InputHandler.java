package racingcar.io;

import static racingcar.messages.InputMessages.INPUT_CAR_NAMES;
import static racingcar.messages.InputMessages.INPUT_NUMBER_OF_ROUNDS;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private final InputValidator inputValidator = new InputValidator();
    private final InputParser inputParser = new InputParser();
    private String input;
    private String[] carNames;
    private String numberOfRoundInput;
    private int numberOfRound;

    public String[] processCarNamesInput() {
        Output.printMessage(INPUT_CAR_NAMES.getMessages());
        input = readInput();
        carNames = inputParser.parseCarNames(input);
        inputValidator.validateCarNames(carNames);
        return carNames;
    }

    public int processNumberOfRoundInput() {
        Output.printMessage(INPUT_NUMBER_OF_ROUNDS.getMessages());
        numberOfRoundInput = readInput();
        inputValidator.validateNumberOfRound(numberOfRoundInput);
        numberOfRound = Integer.parseInt(numberOfRoundInput); // TODO
        return numberOfRound;
    }

    private String readInput() {
        return Console.readLine();
    }

    public void closeConsole() {
        Console.close();
    }
}
