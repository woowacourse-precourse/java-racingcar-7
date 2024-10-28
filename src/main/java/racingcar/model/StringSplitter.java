package racingcar.model;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import racingcar.constant.Separator;

public class StringSplitter {

    private static final Set<String> SEPARATORS = Set.of(
            Separator.COMMA.getSymbol()
    );
    private static final String OR_OPERATOR = "|";
    private static final String REGEX_START = "[";
    private static final String REGEX_END = "]";

    public List<String> splitCarNamesToSeparator(String carNames) {
        String regex = buildRegexFromSeparators();
        Pattern pattern = Pattern.compile(regex);

        return pattern.splitAsStream(carNames)
                .filter(str -> !str.trim().isEmpty())
                .collect(Collectors.toList());
    }

    private String buildRegexFromSeparators() {
        return StringSplitter.SEPARATORS.stream()
                .map(this::escapeSpecialRegexChars)
                .collect(Collectors.joining(OR_OPERATOR, REGEX_START, REGEX_END));
    }

    private String escapeSpecialRegexChars(String separator) {
        return separator.replaceAll("([\\W])", "\\\\$1");
    }
}
