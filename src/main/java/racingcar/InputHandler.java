package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputHandler {

    public static String getRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();

        validateNotBlank(carNamesInput);
        validateCarNames(carNamesInput);

        return carNamesInput;
    }

    public static int getNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        validateNotBlank(input);
        validateNumeric(input);

        int numberOfAttempts = Integer.parseInt(input);
        validateNumberOfAttempts(numberOfAttempts);

        return numberOfAttempts;
    }

    private static void validateCarNames(String carNamesInput) {
        if (containsSpecialCharacters(carNamesInput)) {
            throw new IllegalArgumentException("입력에 특수 문자가 포함되어 있습니다. 문자, 숫자, 하이픈(-) 그리고 구분자 쉼표(,)만 허용됩니다.");
        }

        List<String> carNames = Arrays.asList(carNamesInput.split(","));
        for (String name : carNames) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다: " + name);
            }
        }
    }

    private static boolean containsSpecialCharacters(String name) {
        return !name.matches("[a-zA-Z0-9-,]+");
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }
    }

    private static void validateNumberOfAttempts(int numberOfAttempts) {
        if (numberOfAttempts < 0) {
            throw new IllegalArgumentException("시도 횟수는 0 이상이어야 합니다.");
        }
    }

    private static void validateNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
