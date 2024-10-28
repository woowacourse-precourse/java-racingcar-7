package racingcar.io;

import java.util.Arrays;
import java.util.List;

public class ParserUserInput {
    private final String WOOWA_DELIMITER = ",";

    // 분리해서 이름별로 List<String> 화
    public List<String> split(String parseTarget) {
        return Arrays.asList(parseTarget.split(WOOWA_DELIMITER));
    }
}
