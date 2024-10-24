package racingcar.Car;

public class MovementDistance {
    private static final int INITIAL_POSITION = 0;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 100;
    private final int value;

    public MovementDistance(int value) {
        this.value = value;
    }

    public static MovementDistance initialzeDistance() {
        return new MovementDistance(INITIAL_POSITION);
    }

    public MovementDistance increaseDistanceBy(int stepCount) {
        if(stepCount < MIN_STEP){
                throw new IllegalArgumentException("이동 거리는 최소 1스텝 이상 가능 합니다.");
        }
        if(stepCount > MAX_STEP){
                throw new IllegalArgumentException("이동 거리는 최대 100스텝 까지만 가능 합니다.");
        }
        return new MovementDistance(this.value + stepCount);
    }

    public int getValue() {
        return this.value;
    }
}
