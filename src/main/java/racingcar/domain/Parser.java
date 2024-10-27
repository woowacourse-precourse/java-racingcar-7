package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Parser {
    public static ArrayList<String> parse(String rawCarNames) {
        if (rawCarNames == null || rawCarNames.trim().isEmpty()) {

            ArrayList<String> emptyList = new ArrayList<>();

            return emptyList;
        }else{
            String[] carNamesArray = rawCarNames.split(",");

            ArrayList<String> carNames = new ArrayList<>(Arrays.asList(carNamesArray));

            return carNames;
        }
    }
}
