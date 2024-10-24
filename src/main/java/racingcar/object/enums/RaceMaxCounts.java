package racingcar.object.enums;

public enum RaceMaxCounts {

    MAX_COUNT_OF_CAR(5),
    MAX_COUNT_OF_LAP(10);

    private Integer count;

    RaceMaxCounts(final Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

}
