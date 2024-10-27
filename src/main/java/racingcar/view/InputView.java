package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";
    private static final String NAME_SEPARATOR = ",";

    public String[] readCars() {
        System.out.println(CAR_NAME_PROMPT);
        return Console.readLine().split(NAME_SEPARATOR);
    }

    public int readAttemptCount() {
        System.out.println(ATTEMPT_COUNT_PROMPT);
        return Integer.parseInt(Console.readLine());
    }
}
