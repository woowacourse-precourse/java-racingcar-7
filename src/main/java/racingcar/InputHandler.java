package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public static String getNameOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        return getInput();
    }

    public static int getRaceTimes() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(getInput());
    }

    private static String getInput() {
        return Console.readLine();
    }
}
