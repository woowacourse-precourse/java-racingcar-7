package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.InputValidation;

public class InputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_NAME_EMPTY_ERROR = "자동차 이름은 공백이 될 수 없습니다.";
    private static final String ATTEMPT_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String ATTEMPT_COUNT_EMPTY_ERROR = "게임 횟수는 공백이 될 수 없습니다.";

    public String getCarName() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String input = Console.readLine().trim();

        InputValidation.validateNotEmpty(input, CAR_NAME_EMPTY_ERROR);
        return input;
    }

    public String getAttemptCount() {
        System.out.println(ATTEMPT_COUNT_INPUT_MESSAGE);
        String input = Console.readLine().trim();

        InputValidation.validateNotEmpty(input, ATTEMPT_COUNT_EMPTY_ERROR);
        return input;
    }
}
