package racingcar.util;

import java.util.StringTokenizer;

public class Validator {

    private static final String ERROR = "[ERROR]";

    public void checkCarNamesInput(String carNames) {
        checkEmpty(carNames);
        checkLengthEachCarName(carNames);
    }

    private void checkEmpty(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException(ERROR + ", 빈 값입니다.");
        }
    }

    private void checkLengthEachCarName(String carNames) {
        StringTokenizer tokenizer = new StringTokenizer(carNames, ",");
        while (tokenizer.hasMoreTokens()) {
            if (tokenizer.nextToken().length() > 5) {
                throw new IllegalArgumentException(ERROR + ", 이름의 길이를 초과하셨습니다.");
            }
        }
    }

    public void checkLoopCount(String loopCount) {
        checkPositiveCount(loopCount);
    }

    private void checkPositiveCount(String loopCount) {
        int count = Parser.parseNumber(loopCount);
        if (count <= 0) {
            throw new IllegalArgumentException(ERROR + ", 시도할 횟수는 1 이상 이어야 합니다.");
        }
    }
}
