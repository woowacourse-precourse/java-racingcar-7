package racingcar.util;

import java.util.StringTokenizer;

public class Validator {

    private static final String ERROR = "[ERROR]";

    public void checkCarNamesInput(String carNames) {
        checkEmpty(carNames);
        checkLengthEachCarName(carNames);
    }

    private void checkLengthEachCarName(String carNames) {
        StringTokenizer tokenizer = new StringTokenizer(carNames, ",");
        while (tokenizer.hasMoreTokens()) {
            if (tokenizer.nextToken().length() > 5) {
                throw new IllegalArgumentException(ERROR + ", 이름의 길이를 초과하셨습니다.");
            }
        }
    }

    private void checkEmpty(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException(ERROR + ", 빈 값입니다.");
        }
    }
}
