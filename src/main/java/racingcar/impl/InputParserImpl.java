package racingcar.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.InputParser;

public class InputParserImpl implements InputParser {
    @Override
    public List<String> parseCars(String input) {
        String[] st = input.split(",");
        if (!validLength(st)) {
            throw new IllegalArgumentException();
        }
        return new ArrayList<> (Arrays.asList(st));
    }

    @Override
    public int parseNum(String input) {
        int parseNumber;
        try {
            parseNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return parseNumber;
    }

    public boolean validLength(String[] str){
        for (String s: str) {
            if (s.length() > 5 || s.length() == 0) {
                return false;
            }
        }
        return true;
    }
}
