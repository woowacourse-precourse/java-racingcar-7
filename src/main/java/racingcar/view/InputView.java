package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TIME_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static String getCarNames() {
        printNameInputMessage();
        return getInput();
    }

    public static String getTryCount() {
        printTimeInputMessage();
        return getInput();
    }

    private static void printNameInputMessage() {
        System.out.println(NAME_INPUT_MESSAGE);
    }
    private static void printTimeInputMessage() {
        System.out.println(TIME_INPUT_MESSAGE);
    }
    private static String getInput() {
        return Console.readLine();
    }


}
