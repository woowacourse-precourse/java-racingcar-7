package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    static final String RACING_CAR_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String TRIAL_MSG = "시도할 횟수는 몇 회인가요?";

    public static String readLine_racingCarNames() {
        System.out.println(RACING_CAR_NAME_MSG);
        return Console.readLine();
    }
    public static String readLine_round() {
        System.out.println(TRIAL_MSG);
        return Console.readLine();
    }
}