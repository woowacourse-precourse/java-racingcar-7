package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return parseNames(input);
    }

    public static int getRepeatCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return parseRepeatCount(input);
    }

    private static List<String> parseNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다. 자동차 이름을 입력해 주세요.");
        }
        return Arrays.asList(input.split(","));
    }

    private static int parseRepeatCount(String input) {
        try {
            int repeatCount = Integer.parseInt(input.trim());
            if (repeatCount <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return repeatCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
