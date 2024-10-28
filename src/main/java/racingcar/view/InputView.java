package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.constant.ExceptionMessage.INVALID_COUNT_RANGE;
import static racingcar.constant.ExceptionMessage.INVALID_COUNT_TYPE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public void printCarInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public String getStringInput() {
        return readLine();
    }

    public int getIntegerInput() {
        String input = Console.readLine();
        validateIntegerInput(input);

        return Integer.parseInt(input);
    }

    private void validateIntegerInput(String input) {
        if (input.matches("0+")) {
            throw new IllegalArgumentException(INVALID_COUNT_RANGE.getValue());
        }
        for (char c : input.toCharArray()) {
            if (c - '0' < 0 || c - '9' > 0) {
                throw new IllegalArgumentException(INVALID_COUNT_TYPE.getValue());
            }
        }
    }
}
