package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String REQUEST_MESSAGE_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String REQUEST_MESSAGE_TRY_COUNT = "시도할 횟수는 몇 회인가요?";

    public void printCarNameRequestMessage() {
        System.out.println(REQUEST_MESSAGE_CAR_NAME);
    }

    public void printTryCntRequestMessage() {
        System.out.println(REQUEST_MESSAGE_TRY_COUNT);
    }

    public String getCarName() {
        return Console.readLine();
    }

    public String getTryCnt() {
        return Console.readLine();
    }
}
