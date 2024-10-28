package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputConsoleHandler {

    public static final String CARNAME_INPUT_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String NUN_OF_TRIAL_GUIDE_MESSAGE = "시도할 횟수는 몇 회인가요?";
    public static final String INPUTS_SEPARATOR = ",";

    public void showCarNameGuideMessage() {
        System.out.println(CARNAME_INPUT_GUIDE_MESSAGE);
    }

    public String[] askCarName() {
        return Console.readLine().split(INPUTS_SEPARATOR);
    }

    public void showNumOfTrialGuideMessage() {
        System.out.println(NUN_OF_TRIAL_GUIDE_MESSAGE);
    }

    public int askNumOfTrial() {
        String input = Console.readLine()
                .trim();

        validateNegativeInput(input);
        validateIntegerInput(input);
        validateNumberInput(input);

        try {
            int result = Integer.parseInt(input);
            return result;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("허용 가능한 시도 횟수를 초과하였습니다.", e);
        }
    }

    private void validateNegativeInput(String input) {
        if (input.matches("-\\d+")) {
            throw new IllegalArgumentException("시도할 횟수는 0보다 커야 합니다.");
        }
    }

    private void validateIntegerInput(String input) {
        if (input.matches("\\d+\\.\\d+")) {
            throw new IllegalArgumentException(
                    String.format("시도할 횟수는 정수여야 합니다. 입력 : %s", input)
            );
        }
    }

    private void validateNumberInput(String input) {

        if (input.matches("\\D+.")) {
            throw new IllegalArgumentException(
                    String.format("시도할 횟수에 숫자가 아닌 값이 입력되었습니다. 입력 : %s", input)
            );
        }
    }
}
