package racingcar.view;

import static racingcar.util.InputValidator.validateNotBlank;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_PLAY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String COMMA = ",";
    private static final int MIN_PLAY_COUNT = 1;
    private static final int MAX_PLAY_COUNT = 1000000;

    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String input = Console.readLine();

        validateNotBlank(input);
        validateSingleComma(input);

        return input;
    }

    public int inputPlayCount() {
        System.out.println(INPUT_PLAY_COUNT_MESSAGE);
        String input = Console.readLine();
        int inputNumber = Integer.parseInt(input);

        validateNotBlank(input);
        validatePlayCount(inputNumber);

        return inputNumber;
    }

    private void validateSingleComma(String input) {
        if (input.equals(COMMA)) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePlayCount(int input) {
        if (input < MIN_PLAY_COUNT || input > MAX_PLAY_COUNT)
            throw new IllegalArgumentException();
    }
}
