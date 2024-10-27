package racingcar.util.parser;

import java.util.HashSet;
import java.util.Set;

public class InputStringParser implements StringParser {
    final static String DELIMITER = ",";
    @Override
    public Set<String> extractTokens(final String str) {
        Set<String> tokens = new HashSet<>();
        String[] items = str.split(DELIMITER);

        for (String item : items) {
            item = item.trim();
            if (!tokens.add(item)) {
                throw new IllegalArgumentException();
            }
        }
        return tokens;
    }

}
