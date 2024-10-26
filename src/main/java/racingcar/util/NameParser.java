package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameParser {

    public List<String> carNameParse(final String text) {
        List<String> result = new ArrayList<>();

        String[] carNames = text.split(",");
        for (String carName : carNames) {
            result.add(carName.trim());
        }
        return result;
    }
}
