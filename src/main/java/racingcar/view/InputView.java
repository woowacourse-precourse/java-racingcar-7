package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    Validator validator;

    public InputView(Validator validator) {
        this.validator = validator;
    }

    public List<String> readCarNames() {
        String inputCarsName = Console.readLine();
        return validateInputCarNames(inputCarsName);
    }

    public int readRoofCount() {
        String inputCount = Console.readLine();
        return validateInputRoofCount(inputCount);
    }

    private List<String> validateInputCarNames(String input) {
        validator.validateCarNames(input);
        return Arrays.stream(input.split(","))
                .toList();
    }

    private int validateInputRoofCount(String input) {
        validator.validateRoofCount(input);

        return Integer.parseInt(input);
    }
}
