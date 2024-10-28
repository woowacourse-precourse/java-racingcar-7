package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String carNamesInput = getCarNames();
        int moveCount = getMoveCount();
        // 이후 기능 구현
    }

    private static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        // 입력 유효성 검증
        String[] carNames = input.split(",");
        for (String name : carNames) {
            if (name.trim().isEmpty() || name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }
        return input;
    }

    private static int getMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        try {
            int moveCount = Integer.parseInt(input);
            if (moveCount <= 0) {
                throw new IllegalArgumentException("이동 횟수는 양의 정수여야 합니다.");
            }
            return moveCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 정수로 입력해야 합니다.");
        }
    }
}
