package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

public class InputView {
    public static final String COMMA = ",";

    private InputView() {}

    public static String[] responseForCarNames() {
        String input = InputReader.inputMessage();
        String[] inputCarNames = input.split(COMMA);

        InputValidator.validateCarNames(input);

        return inputCarNames;
    } // responseForCarNames

    public static int responseForRaceCount() {
        String inputTimes = Console.readLine();

        InputValidator.validateRaceCount(inputTimes);

        return Integer.parseInt(inputTimes);
    } // responseForRaceCount
} // class