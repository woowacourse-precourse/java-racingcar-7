package racingcar.domain;

public class MovingCountValidator {

    private int movingCount;

    private MovingCountValidator(int movingCount) {
        validate(movingCount);
        this.movingCount = movingCount;
    }

    private void validate(int movingCount) {
        if(movingCount < 0) {
            throw new IllegalArgumentException("횟수는 음수가 될 수 없습니다.");
        }
    }

    public int getMovingCount() {
        return movingCount;
    }

    public static int from(int movingCount) {
        MovingCountValidator movingCountValidator = new MovingCountValidator(movingCount);
        return movingCountValidator.getMovingCount();
    }
}
