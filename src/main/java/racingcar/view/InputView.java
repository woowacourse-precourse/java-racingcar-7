package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String REQUEST_TRY_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public String readCarNames() {
        System.out.println(REQUEST_CAR_NAME);
        return Console.readLine();
    }

    public String readTryCount() {
        System.out.println(REQUEST_TRY_COUNT);
        return Console.readLine();
    }

    public void closeConsole() {
        Console.close();
    }
}
