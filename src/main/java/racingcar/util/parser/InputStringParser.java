package racingcar.util.parser;

import java.util.HashSet;
import java.util.Set;

public class InputStringParser implements StringParser {
    final static String DELIMITER = ",";

    @Override
    public Set<String> extractTokens(final String str) {
        Set<String> tokens = new HashSet<>();
        validateDelimiter(str);
        String[] items = str.split(DELIMITER);

        for (String item : items) {
            item = item.trim();
            if (!tokens.add(item)) {
                throw new IllegalArgumentException("중복된 이름이 존재할 수 없습니다.");
            }
        }
        return tokens;
    }

    private void validateDelimiter(final String str) {
        String regex = "[^a-zA-Z0-9가-힣,]";
        if (str.matches(".*" + regex + ".*") == true) {
            throw new IllegalArgumentException("쉼표(',')외의 구분자는 허용하지 않습니다.");
        }
    }
}
