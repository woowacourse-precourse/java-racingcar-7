package racingcar.service.parser;

import java.util.List;

public interface ParsingService {
    List<String> parseCarsIntoList(String s);
    Long parseStringIntoLong(String s);
}
