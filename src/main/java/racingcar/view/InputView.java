package racingcar.view;

import static racingcar.constant.ExceptionMessage.INVALID_COUNT_RANGE;
import static racingcar.constant.ExceptionMessage.INVALID_COUNT_TYPE;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

public class InputView {

    private final static char MIN_NUMBER = '0';
    private final static char MAX_NUMBER = '9';

    InputValidator inputValidator = new InputValidator();

    public void printCarInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public String getStringInput() {
        String input = Console.readLine();
        inputValidator.validateEmptyString(input);

        return input;
    }

    public int getIntegerInput() {
        String input = Console.readLine();
        validateIntegerInput(input);

        return Integer.parseInt(input);
    }

    private void validateIntegerInput(String input) {
        inputValidator.validateEmptyString(input);

        if (input.matches(MIN_NUMBER + "+")) {
            throw new IllegalArgumentException(INVALID_COUNT_RANGE.getValue());
        }
        for (char c : input.toCharArray()) {
            if (c - MIN_NUMBER < 0 || c - MAX_NUMBER > 0) {
                throw new IllegalArgumentException(INVALID_COUNT_TYPE.getValue());
            }
        }
    }
}
