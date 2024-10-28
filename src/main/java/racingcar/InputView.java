package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static String requestName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String requestRound = "시도할 횟수는 몇 회인가요?";

    public static String requestCarNames() {
        System.out.println(requestName);
        return Console.readLine();
    }

    public static String requestRound() {
        System.out.println(requestRound);
        return Console.readLine();
    }
}
