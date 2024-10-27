package racingcar.domain;

public class MovingCount {
    private final int movingCount;

    public MovingCount(final String movingCount) {
        validateMovingCountIsNatural(movingCount);
        this.movingCount = convertStringToInt(movingCount);
    }

    private void validateMovingCountIsNatural(String movingCount) {
        if (!movingCount.matches("^[1-9]\\d*$")){
            throw new IllegalArgumentException("이동할 횟수는 자연수여야 합니다.");
        }
    }
    private int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public int getMovingCount() {
        return movingCount;
    }
}
