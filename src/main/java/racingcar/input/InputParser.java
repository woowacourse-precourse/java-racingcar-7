package racingcar.input;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.Constant;

public class InputParser {

    private static final int NAME_LENGTH_MAX = 5;
    private static final String COMMA = ",";
    private static final String SPACE = " ";

    public List<String> toList(final String input) {
        return Arrays.stream(split(input))
                .peek(this::validateSpaceBetweenName)
                .peek(this::validateMaxNameSize)
                .toList();
    }

    private String[] split(final String input) {
        return input.split(COMMA);
    }

    private void validateMaxNameSize(final String input) {
        if (isMaxSize(input)) {
            throw new IllegalArgumentException(Constant.MAX_NAME_SIZE_STRING);
        }
    }

    private void validateSpaceBetweenName(final String input) {
        if (isSpace(input)) {
            throw new IllegalArgumentException(Constant.SPACE_BETWEEN_NAME_STRING);
        }
    }

    private boolean isSpace(final String input) {
        return input.contains(SPACE);
    }

    private boolean isMaxSize(final String input) {
        return input.length() > NAME_LENGTH_MAX;
    }
}
