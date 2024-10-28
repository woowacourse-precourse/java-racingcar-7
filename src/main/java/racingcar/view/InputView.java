package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_TRY_COUNT = "시도할 횟수는 몇 회인가요?";

    public String printAskCarName() {
        printMessage(ASK_CAR_NAME);
        return Console.readLine();
    }

    public String printAskTryCount() {
        printMessage(ASK_TRY_COUNT);
        return Console.readLine();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
