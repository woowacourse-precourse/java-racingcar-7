package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.parser.InputParser;
import racingcar.validation.GameValidation;

public class InputView {
    private final InputParser inputParser;

    public InputView() {
        this.inputParser = new InputParser();
    }

    public List<String> getValidatedCarNames() {
        try {
            String input = Console.readLine();
            List<String> parsedCarNames = inputParser.parseCarNames(input);
            GameValidation.validateCarNames(parsedCarNames);
            return parsedCarNames;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidatedCarNames();
        }
    }
}
