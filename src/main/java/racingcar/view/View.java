package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    private static final String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static void printlnMessage(String message) {
        System.out.println(message);
    }

    private static String enterMessage() {
        return Console.readLine();
    }

    public static String requestCarNames() {
        printlnMessage(REQUEST_CAR_NAMES_MESSAGE);
        return enterMessage();
    }
}