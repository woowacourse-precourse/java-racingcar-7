package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameParser {

    public List<String> carNameParse(final String text) {

        String[] carNames = text.split(",");

        return new ArrayList<>(Arrays.asList(carNames));
    }
}
