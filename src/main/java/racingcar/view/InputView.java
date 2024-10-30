package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String carsInput() {
        return readInput(InputMessage.INPUT_CAR_NAME.toString());
    }

    public static String timesInput() {
        return readInput(InputMessage.INPUT_TIMES.toString());
    }

    private static String readInput(String message) {
        System.out.println(message);
        return Console.readLine(); // 입력을 받는 역할만 수행
    }
}
