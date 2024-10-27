package racingcar.model;

import java.util.List;

public interface InputParser {

    List<String> parseCars(String input);

    int parseNum(String input);
}
