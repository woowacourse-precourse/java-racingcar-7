package racingcar.extractor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarNameExtractor implements Extractor<List<String>> {

    private static final String NAME_DELIMITER = ",";

    @Override
    public List<String> extract(String input) {
        validateInput(input);
        List<String> extractedCarNames = new ArrayList<>();
        Collections.addAll(extractedCarNames, input.split(NAME_DELIMITER));
        return extractedCarNames;
    }

    @Override
    public void validateInput(String input) {
        checkNull(input);
        checkBlank(input);
    }
}
