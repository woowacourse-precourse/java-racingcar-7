package racingcar.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static racingcar.constant.Regex.ALLOWED_CHARACTERS;

public class MatcherUtils {
    private final Pattern pattern = Pattern.compile(ALLOWED_CHARACTERS.value());

    public boolean isMatched(String carNames) {
        Matcher matcher = pattern.matcher(carNames);
        return matcher.find();
    }
}
