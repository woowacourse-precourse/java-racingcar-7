package racingcar.service;

import java.util.Arrays;
import java.util.List;

public class ParsingServiceEmb implements ParsingService {
    @Override
    public List<String> parseCarsIntoList(String s) {
        return Arrays.asList(s.split(","));
    }
}
