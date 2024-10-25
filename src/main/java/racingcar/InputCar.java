package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class InputCar {

    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        return Arrays.asList(input.split(","));
    }

    public static int readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        validateTryCount(input);

        return Integer.parseInt(input);
    }

    private static void validateTryCount(String input) {
        try {
            int tryCount = Integer.parseInt(input);

            if (tryCount <= 0) {
                throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
        }
    }
}
