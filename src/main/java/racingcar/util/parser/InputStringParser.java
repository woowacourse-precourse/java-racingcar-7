package racingcar.util.parser;

import static racingcar.util.Message.ErrorMessage.DUPLICATE_NAME_ERROR;
import static racingcar.util.Message.ErrorMessage.INVALID_DELIMITER_ERROR;

import java.util.HashSet;
import java.util.Set;

public class InputStringParser implements StringParser {
    final static String DELIMITER = ",";
    final static String VALIDATE_DELIMITER_REGEXP = "[^a-zA-Z0-9가-힣,]";

    @Override
    public Set<String> extractTokens(final String str) {
        Set<String> tokens = new HashSet<>();
        validateDelimiter(str);
        String[] items = str.split(DELIMITER);

        for (String item : items) {
            item = item.trim();
            if (!tokens.add(item)) {
                throw new IllegalArgumentException(DUPLICATE_NAME_ERROR);
            }
        }
        return tokens;
    }

    private void validateDelimiter(final String str) {
        if (str.matches(".*" + VALIDATE_DELIMITER_REGEXP + ".*") == true) {
            throw new IllegalArgumentException(INVALID_DELIMITER_ERROR);
        }
    }
}
