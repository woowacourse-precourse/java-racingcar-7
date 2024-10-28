package racingcar.move;

public enum CarRaceMoveConfig {

    DEFAULT(0, 9, 4);

    private final int startInclusive;
    private final int endInclusive;
    private final int aboveStandard;

    CarRaceMoveConfig(int startInclusive, int endInclusive, int aboveStandard) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
        this.aboveStandard = aboveStandard;
    }

    public int getStartInclusive() {
        return startInclusive;
    }

    public int getEndInclusive() {
        return endInclusive;
    }

    public int getAboveStandard() {
        return aboveStandard;
    }
}
