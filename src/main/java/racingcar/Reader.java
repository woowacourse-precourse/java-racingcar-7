package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Reader {

    public static List<String> readCarNames() {
        String input = Console.readLine();

        return splitNameInput(input);
    }

    public static List<String> splitNameInput(String input) {
        verifyNameInput(input);

        List<String> carNames = Arrays.asList(input.split(","));
        verifyCarNames(carNames);

        return carNames;

    }

    private static void verifyNameInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 null이나 공백, 빈 칸일 수 없습니다.");
        }
    }

    private static void verifyCarNames(List<String> carNames) {
        for (String name: carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
            }
        }

        if (carNames.size() == 0 || carNames.contains(" ")) {
            throw new IllegalArgumentException("자동차의 이름은 공백이나 빈 칸일 수 없습니다.");
        }

        Set<String> carNameSet = new HashSet<>(carNames);
        if (carNameSet.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차의 이름은 서로 중복될 수 없습니다");
        }
    }

    public static int readNumber() {
        String input = Console.readLine();

        return convertStringToNaturalNumber(input);
    }

    public static int convertStringToNaturalNumber(String input) {

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
        if (number < 1) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
        }
    }

    public static void closeConsole() {

        Console.close();
    }
}
