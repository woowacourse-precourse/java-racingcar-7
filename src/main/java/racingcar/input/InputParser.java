package racingcar.input;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.Constant;

public class InputParser {

    public InputParser() {
    }

    public List<String> toList(String input) {
        return Arrays.stream(split(input))
                .peek(this::validateSpaceBetweenName)
                .peek(this::validateMaxNameSize)
                .toList();
    }

    private String[] split(String input) {
        return input.split(Constant.COMMA);
    }

    private void validateMaxNameSize(String input) {
        if (isMaxSize(input)) {
            throw new IllegalArgumentException(Constant.MAX_NAME_SIZE_STRING);
        }
    }

    private void validateSpaceBetweenName(String input) {
        if (isSpace(input)) {
            throw new IllegalArgumentException(Constant.SPACE_BETWEEN_NAME_STRING);
        }
    }

    private boolean isSpace(String input) {
        return input.contains(Constant.SPACE);
    }

    private boolean isMaxSize(String input) {
        return input.length() > Constant.MAX_SIZE;
    }
}
