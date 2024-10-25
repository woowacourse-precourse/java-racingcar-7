package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Reader {

    public static List<String> readCarNames() {
        String input = Console.readLine();
        verifyNameInput(input);

        List<String> carNames = Arrays.asList(input.split(","));
        verifyCarNames(carNames);

        Console.close();

        return carNames;
    }

    private static void verifyNameInput(String input) {
        if (input == null || input.isBlank())
            throw new IllegalArgumentException("자동차의 이름은 null이나 공백, 빈 칸일 수 없습니다.");
    }

    private static void verifyCarNames(List<String> carNames) {
        for (String name: carNames) {
            if (name.length() > 5)
                throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    public static int readNumber() {
        String input = Console.readLine();
        int number = Integer.parseInt(input);

        Console.close();

        return number;
    }
}
