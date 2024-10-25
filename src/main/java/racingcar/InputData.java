package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputData {

    private static final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static String getInputData() {
        printInputMessage();
        return Console.readLine();
    }

    private static void printInputMessage() {
        System.out.println(GAME_START_MESSAGE);
    }
}
