package racingcar.service;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public List<String> parseCarList(String input) {
        String[] inputArr = input.split(",");
        return Arrays.asList(inputArr);
    }
}
