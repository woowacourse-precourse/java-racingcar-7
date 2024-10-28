package racingcar.controller.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {
    public static List<String> parseCarNames(String carNamesInput) {
        StringTokenizer tokenizer = new StringTokenizer(carNamesInput, ",");
        List<String> carNames = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            carNames.add(tokenizer.nextToken().trim());
        }
        return carNames;
    }
}
