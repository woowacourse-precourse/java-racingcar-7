package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_ATTEMPT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public String getCarNames() {
        System.out.println(INPUT_CARS_NAME_MESSAGE);
        return Console.readLine();
    }

    public String getGameAttempt() {
        System.out.println(GAME_ATTEMPT_INPUT_MESSAGE);
        return Console.readLine();
    }

}
