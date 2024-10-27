package racingcar.model;

public class Validator {
    public void validateCarName(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    public int validateAttemptCount(String moveCountInput) {
        if (moveCountInput == null || moveCountInput.isEmpty()) {
            throw new IllegalArgumentException("이동 횟수는 빈 값일 수 없습니다.");
        }

        int moveCount = Integer.parseInt(moveCountInput);

        if (moveCount < 0) {
            throw new IllegalArgumentException("이동 횟수는 0 이상의 정수여야 합니다.");
        }

        return moveCount;
    }
}
