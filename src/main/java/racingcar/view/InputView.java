package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String NUMBER_ERROR_MESSAGE = "숫자만 입력 가능합니다.";

    private static String inputValue() {
        return Console.readLine();
    }

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return inputValue();
    }

    public static int inputRound() {
        System.out.println(INPUT_ROUND_MESSAGE);
        return inputNumberValue();
    }

    private static int inputNumberValue() {
        String inputValue = inputValue();
        validateNumber(inputValue);
        return Integer.parseInt(inputValue);
    }

    private static void validateNumber(String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }
}
