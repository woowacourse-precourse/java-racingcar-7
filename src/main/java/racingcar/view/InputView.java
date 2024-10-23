package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT = "시도할 횟수는 몇 회 인가요?";

    public static void print(String message) {
        System.out.println(message);
    }

    public static List<String> getCarNames() {
        print(CAR_NAME_INPUT);
        List<String> carNames = List.of(Console.readLine().split(","));
        return carNames;
    }

    public static String getAttempts() {
        print(TRY_COUNT_INPUT);
        String tryCount = Console.readLine();
        return tryCount;
    }
}
