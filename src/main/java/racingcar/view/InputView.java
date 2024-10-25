package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_NAME_PROMPT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUM_ATTEMPT_PROMPT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public void requestCarNames() {
        System.out.println(CAR_NAME_PROMPT_MESSAGE);
    }

    public void requestNumAttempt() {
        System.out.println(NUM_ATTEMPT_PROMPT_MESSAGE);
    }

    public String readInput() {
        String input = Console.readLine();
        Console.close();
        return input;
    }
}
