package racingcar;

import java.util.List;

public class Validator {
    private static final String ERROR_MESSAGE_INPUT_EMPTY = "자동차 이름을 입력해주세요.";
    private static final String ERROR_MESSAGE_ROUND_FORMAT = "숫자만 입력 가능해요.";
    private static final String ERROR_MESSAGE_ROUND_RANGE = "자연수만 입력 가능해요";

    public static void inputSting(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_EMPTY);
        }
    }

    public static void CheckCarList(List<Car> carList) {
        for (Car car : carList) {

        }
    }

    public static void checkRound(String input) {
        int round;

        try {
            round = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ROUND_FORMAT);
        }
        if (round <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ROUND_RANGE);
        }
    }
}
