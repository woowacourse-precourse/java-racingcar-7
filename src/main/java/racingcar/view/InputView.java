package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_ATTEMPT_COUNT = "시도할 횟수는 몇 회인가요?";

    public String inputCarNames() {
        System.out.println(ASK_CAR_NAMES);
        return Console.readLine();
    }

    public String inputAttemptCount() {
        System.out.println(ASK_ATTEMPT_COUNT);
        return Console.readLine();
    }
}
