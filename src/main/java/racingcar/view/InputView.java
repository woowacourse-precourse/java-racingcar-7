package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVE_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static void printCarInputMessage() {
        System.out.println(CAR_INPUT_MESSAGE);
    }

    public static String readCars() {
        return Console.readLine();
    }

    public static void printMoveInputMessage() {
        System.out.println(MOVE_INPUT_MESSAGE);
    }

    public static int readMoveNumber() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
