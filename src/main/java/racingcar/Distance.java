package racingcar;

public class Distance {
    private static final int INITIAL_POSITION = 0;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 100;
    private final int value;

    public Distance(int value) {
        this.value = value;
    }

    public static Distance initialzeDistance() {
        return new Distance(INITIAL_POSITION);
    }

    public Distance increaseDistanceBy(int stepCount) {
        if(stepCount < MIN_STEP){
                throw new IllegalArgumentException("이동 거리는 최소 1스텝 이상 가능 합니다.");
        }
        if(stepCount > MAX_STEP){
                throw new IllegalArgumentException("이동 거리는 최대 100스텝 까지만 가능 합니다.");
        }
        return new Distance(this.value + stepCount);
    }

    public int getValue() {
        return this.value;
    }
}
