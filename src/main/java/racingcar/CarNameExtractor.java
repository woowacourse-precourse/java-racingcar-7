package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarNameExtractor {

    private static final String NAME_DELIMITER = ",";

    public List<String> extractCarNames(String rawString) {
        List<String> extractedCarNames = new ArrayList<>();
        Matcher matcher = Pattern.compile(NAME_DELIMITER).matcher(rawString);

        while (matcher.find()) {
            extractedCarNames.add(matcher.group());
        }
        return extractedCarNames;
    }
}
