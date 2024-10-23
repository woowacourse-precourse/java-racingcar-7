package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.common.ErrorMessage.ATTEMPT_COUNT_MINIMUM_ERROR;

public class InputView {

    private static final String INPUT_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public String getCarNames() {
        System.out.println(INPUT_CARS_NAME_MESSAGE);
        return Console.readLine();
    }

    public int getGameAttempt() {
        String input = Console.readLine();
        int inputNum = Integer.parseInt(input);
        validateTrialNum(inputNum);
        return inputNum;
    }

    private static void validateTrialNum(int num) {
        if (num < 2) {
            throw new IllegalArgumentException(ATTEMPT_COUNT_MINIMUM_ERROR.getMessage());
        }
    }
}
