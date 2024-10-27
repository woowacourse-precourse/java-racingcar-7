package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class IOHandler {

    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static String inputMessage() {
        System.out.println(START_MESSAGE);
        return Console.readLine();
    }

    public static String inputTryCount() {
        System.out.println(TRY_COUNT_MESSAGE);
        return Console.readLine();
    }

    public static void resultMessage(RacingCar racingCar) {
        System.out.print(racingCar.getName() + " : ");
        System.out.println("-".repeat(racingCar.getCount()));
    }

    public static void printWinner(String winner) {
        System.out.println(winner);
    }
}
