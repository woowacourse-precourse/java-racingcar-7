package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingInputView {
    private static final String MESSAGE_CAR_NAMES_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MESSAGE_MOVE_COUNT_INPUT = "시도할 횟수는 몇 회인가요?";
    private static final String ERROR_CAR_NAMES_BLANK = "자동차 이름은 공백일 수 없습니다.";
    private static final String ERROR_MOVE_COUNT_NOT_INTEGER = "횟수는 숫자만 가능합니다.";

    private void validateBlankInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_CAR_NAMES_BLANK);
        }
    }

    public List<String> getCarNames() {
        System.out.println(MESSAGE_CAR_NAMES_INPUT);
        String Input = Console.readLine().strip();
        validateBlankInput(Input);
        return List.of(Input.split(","));
    }

    private boolean isInteger(String input) {
        return input.matches("-?\\d+");
    }

    private void validateIntegerInput(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(ERROR_MOVE_COUNT_NOT_INTEGER);
        }
    }

    public Integer getMoveCount() {
        System.out.println(MESSAGE_MOVE_COUNT_INPUT);
        String input = Console.readLine().strip();
        validateIntegerInput(input);
        return Integer.parseInt(input);
    }
}
