package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static String requestName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String requestRound = "시도할 횟수는 몇 회인가요?";

    private static String carNames;
    private static String round;

    public static void requestCarNames() {
        System.out.println(requestName);
        carNames = Console.readLine();
    }

    public static void requestRound() {
        System.out.println(requestRound);
        round = Console.readLine();
    }

    public static void requestInput() {
        requestCarNames();
        requestRound();
    }

    public static String round() {
        return round;
    }

    public static String carNames() {
        return carNames;
    }
}
