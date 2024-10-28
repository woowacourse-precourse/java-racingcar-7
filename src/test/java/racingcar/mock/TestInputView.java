package racingcar.mock;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.ViewConstants;
import racingcar.exception.InputException;
import racingcar.view.InputView;

public class TestInputView implements InputView {
    private final String input;

    public TestInputView(String input) {
        this.input = input;
    }

    @Override
    public List<String> readNames() {
        if (input == null || input.trim().isEmpty()) {
            throw new InputException.InvalidNameFormatException();
        }
        return Arrays.asList(input.split(ViewConstants.NAME_DELIMITER));
    }

    @Override
    public int readRounds() {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InputException.InvalidRoundInputException();
        }
    }
}