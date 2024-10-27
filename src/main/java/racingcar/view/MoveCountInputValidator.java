package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class MoveCountInputValidator {
    public int getMoveCount() {
        System.out.println("자동차가 이동할 횟수를 입력하세요.");
        String input = Console.readLine();
        return validateMoveCount(input);
    }

    public int validateMoveCount(String input) {
        try {
            long moveCount = Long.parseLong(input);
            if (moveCount < 0) {
                throw new IllegalArgumentException("이동 횟수는 0 이상의 정수여야 합니다.");
            }
            if (moveCount > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("이동 횟수는 정수 범위를 초과할 수 없습니다.");
            }
            return (int) moveCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다.");
        }
    }
}
