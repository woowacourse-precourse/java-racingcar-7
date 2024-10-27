package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Parser {
    public static ArrayList<String> parse(String rawCarNames) {
        if (rawCarNames == null || rawCarNames.trim().isEmpty()) {

            return new ArrayList<>();
        }else{
            String[] carNamesArray = rawCarNames.split(",");

            return new ArrayList<>(Arrays.asList(carNamesArray));
        }
    }
}
