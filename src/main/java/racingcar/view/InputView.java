package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String DELIMITER = ",";

    public static List<String> getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.stream(readLine().split(DELIMITER)).toList();
    }

    public static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = readLine();
        validateTryCount(input);
        return Integer.parseInt(input);
    }

    private static String readLine() {
        return Console.readLine();
    }

    private static void validateTryCount(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상의 숫자여야 합니다.");
        }
    }
}
