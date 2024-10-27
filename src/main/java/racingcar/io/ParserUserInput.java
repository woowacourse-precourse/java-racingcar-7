package racingcar.io;

import java.util.Arrays;
import java.util.List;

public class ParserUserInput {
    private final String WOOWA_DELIMITER = ",";

    public void hasOnlyCharacters(String testTarget) {
        for (Character each : testTarget.toCharArray()) {
            if (!Character.isLetter(each)) { // (issue) isLetter는 한글 자음 모음이 분리될 경우 false를 리턴한다
                throw new IllegalArgumentException();
            }
        }
    }

    // 분리해서 이름별로 List<String> 화
    public List<String> split(String parseTarget) {
        return Arrays.asList(parseTarget.split(WOOWA_DELIMITER));
    }
}
