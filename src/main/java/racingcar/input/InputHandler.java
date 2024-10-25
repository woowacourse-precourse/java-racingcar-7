package racingcar.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

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
    public void inputCarNames() {
        input = readLine();
    }

//    private static String inputCarNames() {
//        return readLine();
//    }

//    public String[] getCarNames() {
//        return carNames;
//    }

    public String[] inputCarNameProcess() {
        inputCarNames();
        carNames = inputParser.parseCarNames(input);
        inputValidator.validateCarNames(carNames);
        return carNames;
    }


    private void inputNumberOfRound() {
        numberOfRound = Integer.parseInt(readLine());
    }

    public int inputNumberOfRoundProcess() {
        inputValidator.validateNumberOfRound(numberOfRound);
        return numberOfRound;
    }
}
