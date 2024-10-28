package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    private static final String INPUT_MESSAGE_FOR_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_MESSAGE_FOR_TRY_COUNT = "시도할 횟수는 몇 회인가요?";

    static String readCarNames() {
        System.out.println(INPUT_MESSAGE_FOR_CAR_NAME);
        return Console.readLine();
    }

    static String readTryCount() {
        System.out.println(INPUT_MESSAGE_FOR_TRY_COUNT);
        return Console.readLine();
    }
}
