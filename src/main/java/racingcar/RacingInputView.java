package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingInputView {
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVE_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String CAR_NAMES_BLANK_ERROR = "자동차 이름은 공백일 수 없습니다.";
    private static final String MOVE_COUNT_NOT_INTEGER_ERROR = "횟수는 숫자만 가능합니다.";

    private void validateBlankInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(CAR_NAMES_BLANK_ERROR);
        }
    }

    public String getCarNamesInput() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String Input = Console.readLine().strip();
        validateBlankInput(Input);
        return Input;
    }

    private boolean isInteger(String input) {
        return input.matches("-?\\d+");
    }

    private void validateNumberInput(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException(MOVE_COUNT_NOT_INTEGER_ERROR);
        }
    }

    public Integer getMoveCount() {
        System.out.println(MOVE_COUNT_INPUT_MESSAGE);
        String input = Console.readLine().strip();
        validateNumberInput(input);
        return Integer.parseInt(input);
    }
}
