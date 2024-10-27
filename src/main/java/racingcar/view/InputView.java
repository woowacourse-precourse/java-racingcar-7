package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.ErrorMessage;

public class InputView {
    private static final String DELIMITER = ",";

    public List<String> getCarNames() {
        System.out.println(ViewMessage.INPUT_CAR_NAMES.getMessage());
        String carNames = Console.readLine();
        validateNull(carNames);
        validateBlank(carNames);
        return splitCarNames(carNames);
    }

    private void validateNull(final String string) {
        if (string == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT.getMessage());
        }
    }

    private void validateBlank(final String string) {
        if (string.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT.getMessage());
        }
    }

    private List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER)).toList();
    }
}