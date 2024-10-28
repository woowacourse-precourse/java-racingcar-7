package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String CAR_NAME_INPUT_PROMPT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉽표(,) 기준으로 구분)";
    private static final String RACING_ATTEMPT_COUNT = "시도할 횟수는 몇 회인가요?";

    public String inputRacingCarNames() {
        System.out.println(CAR_NAME_INPUT_PROMPT_MESSAGE);

        return Console.readLine();
    }

    public String inputAttemptCount() {
        System.out.println(RACING_ATTEMPT_COUNT);

        return Console.readLine();
    }
}
