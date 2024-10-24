package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_RACE_ROUND_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public String requestCarNames() {
        System.out.println(REQUEST_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public String requestRaceRound() {
        System.out.println(REQUEST_RACE_ROUND_MESSAGE);
        return Console.readLine();
    }
}
