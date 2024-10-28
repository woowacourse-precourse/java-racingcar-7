package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import racingcar.vo.ExceptionMessage;

public class Input {

    public int readPlayCount() {
        String playCount = Console.readLine();

        validateNotNumber(playCount);
        validateNotPositive(playCount);

        return Integer.valueOf(playCount);
    }

    private void validateNotNumber(String playCount) {
        boolean isNotNumber = !Pattern.matches("^(0|[0-9]+)$", playCount);

        if (isNotNumber) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NUMBER.getMessage());
        }
    }

    private void validateNotPositive(String playCount) {
        boolean isNotPositive = Integer.parseInt(playCount) < 1;

        if (isNotPositive) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NEGATIVE_NUMBER.getMessage());
        }
    }

    public List<String> readCarNames() {
        String[] carNames = Console.readLine().split(",");

        return Arrays.stream(carNames)
                .map(String::trim)
                .filter(this::isReadCarNameValidate)
                .toList();
    }

    private boolean isReadCarNameValidate(String carName) {
        validateAllowedName(carName);
        validateCommaPosition(carName);
        return true;
    }

    private void validateCommaPosition(String carName) {
        if (carName.startsWith(",") || carName.endsWith(",")) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NAME.getMessage());
        }
    }

    private void validateAllowedName(String carName) {
        boolean isNotAllowedName = !Pattern.matches("[a-zA-z\\d,]+", carName);

        if (isNotAllowedName) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_ALLOWED_NAME.getMessage());
        }
    }
}
