package racingcar.object;

import racingcar.object.enums.RaceMaxCounts;

public class Mileage implements Comparable<Mileage> {

    private Integer mileage;

    public Mileage() {
        this(0);
    }

    public Mileage(final Integer mileage) {
        if (mileage == null) {
            throw new IllegalArgumentException("주행거리가 입력되지 않았습니다.");
        }
        if (mileage < 0) {
            throw new IllegalArgumentException("주행거리는 음수일 수 없습니다.");
        }
        if (0 < mileage.compareTo(RaceMaxCounts.MAX_COUNT_OF_LAP.getCount())) {
            throw new IllegalArgumentException("주행거리는 최대 랩 수를 벗어날 수 없습니다.");
        }

        this.mileage = mileage;
    }

    public void increase() {
        if (mileage.equals(RaceMaxCounts.MAX_COUNT_OF_LAP.getCount())) {
            throw new IllegalArgumentException("최대 랩 수를 초과할 수 없습니다.");
        }

        mileage++;
    }

    public Integer getMileage() {
        return mileage;
    }

    @Override
    public int compareTo(Mileage other) {
        if (other == null) {
            throw new IllegalArgumentException("null과 비교할 수 없습니다.");
        }
        return mileage - other.mileage;
    }

}
