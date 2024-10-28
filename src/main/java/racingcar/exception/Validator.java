package racingcar.exception;

import camp.nextstep.edu.missionutils.Console;

public abstract class Validator {
    private static final int MAX_LENGTH = 5;

    public static String validateNameLength(String carNames) {
        if (carNames.length() > MAX_LENGTH) {
            Console.close();
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다");
        }
        return carNames;
    }

    public static int validateCircleCountIfNegative(String circleCount) {
        int countAsInt = Integer.parseInt(circleCount);
        if (countAsInt < 0) {
            Console.close();
            throw new IllegalArgumentException("순회 횟수 입력은 1이상 이여야 합니다.");
        }
        return countAsInt;
    }
}
