package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputCount {

    private static final String COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static String getInputCountData() {
        System.out.println(COUNT_MESSAGE);
        return Console.readLine();
    }
}
