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
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
        }

        verifyNumber(number);

        return number;
    }

    private static void verifyNumber(int number) {
        if (number <= 0)
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
    }

    public static void closeConsole() {

        Console.close();
    }
}
