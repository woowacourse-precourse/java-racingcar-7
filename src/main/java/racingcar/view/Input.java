package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ErrorType;

public class Input {

    private static final int MAXIMUM_COUNT = 10;

    public String readNames() {
        return Console.readLine();
    }

    public int readCount() {
        try {
            int count = Integer.parseInt(Console.readLine());
            if (count > MAXIMUM_COUNT) {
                throw new IllegalArgumentException(ErrorType.EXCEEDED_MAXIMUM_COUNT.getMessage());
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorType.INVALIDED_COUNT_TYPE.getMessage());
        }
    }
}
