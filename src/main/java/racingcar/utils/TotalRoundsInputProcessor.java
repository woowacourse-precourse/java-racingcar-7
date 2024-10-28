package racingcar.utils;

public class TotalRoundsInputProcessor {
    private final int totalRounds;

    public TotalRoundsInputProcessor(String roundInput) {
        validInput(roundInput);
        this.totalRounds = parseCount(roundInput);
    }

    public void validInput(String roundInput) {
        if (roundInput == null || roundInput.trim().isEmpty()) {
            throw new IllegalArgumentException("전진 횟수는 빈 값이나 공백일 수 없습니다.");
        }
    }

    private int parseCount(String roundInput) {
        try {
            int totalRounds = Integer.parseInt(roundInput);
            if (totalRounds <= 0) {
                throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 합니다.");
            }
            return totalRounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }


    public int getTotalRounds() {
        return totalRounds;
    }
}
