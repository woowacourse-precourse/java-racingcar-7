package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Converter {

    public List<String> parseCarList(String input) {
        String[] inputArr = input.split(",");
        return Arrays.asList(inputArr);
    }
}
