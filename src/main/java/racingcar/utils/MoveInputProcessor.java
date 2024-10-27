package racingcar.utils;

public class MoveInputProcessor {
    private final int moveCount;

    public MoveInputProcessor(String moveInput) {
        validInput(moveInput);
        this.moveCount = parseCount(moveInput);
    }

    public void validInput(String moveInput) {
        if (moveInput == null || moveInput.trim().isEmpty()) {
            throw new IllegalArgumentException("전진 횟수는 빈 값이나 공백일 수 없습니다.");
        }
    }

    private int parseCount(String moveInput) {
        try {
            int moveCount = Integer.parseInt(moveInput);
            if (moveCount <=0){
                throw new IllegalArgumentException("이동 횟수는 1 이상이어햐 합니다.");
            }
            return moveCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }


    public int getMoveCount() {
        return moveCount;
    }
}
