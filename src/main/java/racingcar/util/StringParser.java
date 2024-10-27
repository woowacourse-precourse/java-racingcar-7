package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParser {
    public List<String> parseCarNameString(String input) {
        List<String> carNameList = Arrays.asList(input.split(","));
        for (String carName : carNameList) {
            carNameList.set(carNameList.indexOf(carName), carName.trim());
        }

        return carNameList;
    }

    public int parseTryCountString(String input) {
        return Integer.parseInt(input);
    }
}
