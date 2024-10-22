package racingcar.domain;

public class RacingTryCount {

    private final int count;

    public RacingTryCount(String input) {
        int count = toInt(input);

        //TODO : 1 상수처리
        if (count < 1) {
            throw new IllegalArgumentException("시도할 횟수는 양수여야 합니다.");
        }

        this.count = count;
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자여야 합니다.");
        }
    }

    public int getCount() {
        return count;
    }
}
