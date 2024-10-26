package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Parser {
    public static ArrayList<String> parse(String rawCarNames) {
        String[] carNamesArray = rawCarNames.split(",");
        ArrayList<String> carNames = new ArrayList<>(Arrays.asList(carNamesArray));

        return carNames;
    }
}
