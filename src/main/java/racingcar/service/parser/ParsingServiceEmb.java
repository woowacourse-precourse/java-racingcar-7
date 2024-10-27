package racingcar.service.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParsingServiceEmb implements ParsingService {
    @Override
    public List<String> parseCarsIntoList(String s) {
        return Arrays.asList(s.split(","));
    }

    @Override
    public Long parseStringIntoLong(String s) {
        return Long.parseLong(s);
    }
}
