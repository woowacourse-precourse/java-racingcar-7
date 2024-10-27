package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static final String REQUEST_TOTAL_ROUNDS = "시도할 횟수는 몇 회인가요?";

    public static void requestCarNames() {
        System.out.println(REQUEST_CAR_NAMES);
    }

    public static void requestTotalRounds() {
        System.out.println(REQUEST_TOTAL_ROUNDS);
    }

    public static String getCarNames() {
        return Console.readLine();
    }

    public static String getTotalRounds() {
        return Console.readLine();
    }
}
