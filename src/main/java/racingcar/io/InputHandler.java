package racingcar.io;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.messages.InputMessages.INPUT_CAR_NAMES;
import static racingcar.messages.InputMessages.INPUT_NUMBER_OF_ROUNDS;

public class InputHandler {
    private final InputValidator inputValidator = new InputValidator();
    private final InputParser inputParser = new InputParser();
    private String input; // TODO 변수명 변경
    private String[] carNames;
    private int numberOfRound;

    //    public String getInput() {
//        return carNames;
//    }
//
    public void readCarNames() {
        input = readLine();
    }

//    private static String inputCarNames() {
//        return readLine();
//    }

//    public String[] getCarNames() {
//        return carNames;
//    }

    public String[] processCarNamesInput() {
        Output.printMessage(INPUT_CAR_NAMES.getMessages());
        readCarNames();
        carNames = inputParser.parseCarNames(input);
        inputValidator.validateCarNames(carNames);
        return carNames;
    }


    private void readNumberOfRound() {
        numberOfRound = Integer.parseInt(readLine());
    }

    public int processNumberOfRoundInput() {
        Output.printMessage(INPUT_NUMBER_OF_ROUNDS.getMessages());
        inputValidator.validateNumberOfRound(numberOfRound);
        return numberOfRound;
    }
}
