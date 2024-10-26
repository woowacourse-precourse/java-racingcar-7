package racingcar.io;

import static racingcar.messages.InputMessages.INPUT_CAR_NAMES;
import static racingcar.messages.InputMessages.INPUT_NUMBER_OF_ROUNDS;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private final InputValidator inputValidator = new InputValidator();
    private final InputParser inputParser = new InputParser();
    private String input; // TODO 변수명 변경
    private String[] carNames;
    private int numberOfRound;

    public String[] processCarNamesInput() {
        Output.printMessage(INPUT_CAR_NAMES.getMessages());
        readCarNames();
        carNames = inputParser.parseCarNames(input);
        inputValidator.validateCarNames(carNames);
        return carNames;
    }

    public int processNumberOfRoundInput() {
        Output.printMessage(INPUT_NUMBER_OF_ROUNDS.getMessages());
        readNumberOfRound();
        inputValidator.validateNumberOfRound(numberOfRound);
        return numberOfRound;
    }

    private void readCarNames() {
        input = Console.readLine();
    }

    private void readNumberOfRound() {
        numberOfRound = Integer.parseInt(Console.readLine());
    }

    public void closeConsole() {
        Console.close();
    }
}
