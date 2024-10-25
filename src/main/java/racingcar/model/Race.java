package racingcar.model;

public class Race {
    private int moveNumber;

    public Race(String moveNumber) {
        this.moveNumber = transferNumberStringToInt(moveNumber);
    }

    private int transferNumberStringToInt(String moveNumberString) {
        try {
            int moveNumber = Integer.parseInt(moveNumberString);
            validatePositiveMoveNumber(moveNumber);
            return moveNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 된 이동 횟수를 입력해주세요.");
        }
    }
    private void validatePositiveMoveNumber(int moveNumber) {
        if (moveNumber < 1) {
            throw new IllegalArgumentException("1회 이상의 이동 횟수를 입력해주세요.");
        }
    }
}
