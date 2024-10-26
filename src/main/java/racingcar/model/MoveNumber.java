package racingcar.model;

public class MoveNumber {
    private final int moveNumber;

    public MoveNumber(int moveNumber) {
        validatePositiveMoveNumber(moveNumber);
        this.moveNumber = moveNumber;
    }

    private void validatePositiveMoveNumber(int moveNumber) {
        if (moveNumber < 1) {
            throw new IllegalArgumentException("1회 이상의 이동 횟수를 입력해주세요.");
        }
    }

    public int getMoveNumber() {
        return moveNumber;
    }

}
