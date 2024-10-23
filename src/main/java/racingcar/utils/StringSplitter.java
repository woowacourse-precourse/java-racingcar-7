package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {

    private static final String SPLIT_DELIMITER = ",";

    public List<String> splitByDelimiter(String userInput){
        return Arrays.asList(userInput.split(SPLIT_DELIMITER));
    }

}
