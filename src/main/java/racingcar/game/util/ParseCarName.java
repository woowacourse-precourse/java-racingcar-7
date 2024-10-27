package racingcar.game.util;

import java.util.Arrays;
import java.util.List;

public class ParseCarName {
    static final String PARSE_DELIMITER = ",";
    public static List<String> parse(String inputCarNames){
        List<String> carNameList = Arrays.asList(inputCarNames.split(PARSE_DELIMITER));
        return carNameList;
    }
    private ParseCarName() {
    }
}
