package racingcar.util;

public class InputValidator {

    public static void validate(String carNames, String moves) {
        String[] names = carNames.split(",");
        for (String name : names) {
            validateCarName(name);
        }

        validateMoves(moves);
    }

    private static void validateCarName(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }

        if (input.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
        }
    }

    private static void validateMoves(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }

        try {
            int moves = Integer.parseInt(input);
            if (moves < 1) {
                throw new IllegalArgumentException("[ERROR] 이동 횟수는 1 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
