package racingcar;

import java.util.Scanner;

public class CarInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = scanner.nextLine();
        String[] carNames = input.split(",");

        validateCarNames(carNames);

        return carNames;
    }

    private static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.trim().isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다: " + name);
            }
        }
    }

    public static int inputMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();

        return validateMoveCount(input);
    }

    private static int validateMoveCount(String input) {
        try {
            int moveCount = Integer.parseInt(input);
            if (moveCount < 1) {
                throw new IllegalArgumentException("이동 횟수는 1 이상의 정수여야 합니다.");
            }
            return moveCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다.");
        }
    }
}