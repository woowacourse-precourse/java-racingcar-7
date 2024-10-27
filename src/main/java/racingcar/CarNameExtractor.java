package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarNameExtractor {

    private static final String NAME_DELIMITER = ",";

    public List<String> extractCarNames(String rawString) {
        List<String> extractedCarNames = new ArrayList<>();

        for (String name : rawString.split(NAME_DELIMITER)) {
            extractedCarNames.add(name);
        }
        return extractedCarNames;
    }
}
