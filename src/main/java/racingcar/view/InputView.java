package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final String COMMA = ",";

    private InputView() {}

    public static List<String> responseForCarNames() {
        String input = InputReader.inputMessage();
        List<String> inputCarNames = Arrays.stream(input.split(COMMA)).toList();

        InputValidator.validateCarNames(input);

        return inputCarNames;
    } // responseForCarNames

    public static int responseForRaceCount() {
        String inputTimes = Console.readLine();

        InputValidator.validateRaceCount(inputTimes);

        return Integer.parseInt(inputTimes);
    } // responseForRaceCount
} // class