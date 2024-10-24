package racingcar.object.value;

import racingcar.object.enums.RaceMaxCounts;

public record Mileage(Integer distance) implements Comparable<Mileage> {

    public static final int LIMIT_OF_DISTANCE = RaceMaxCounts.MAX_COUNT_OF_LAP.getCount();

    public Mileage {
        if (distance == null) {
            throw new IllegalArgumentException("주행거리가 입력되지 않았습니다.");
        }
        if (distance < 0) {
            throw new IllegalArgumentException("주행거리는 음수일 수 없습니다.");
        }
        if (LIMIT_OF_DISTANCE < distance) {
            throw new IllegalArgumentException("주행 한계 거리를 넘어설 수 없습니다.");
        }
    }

    public Mileage getIncreased() {
        return new Mileage(distance + 1);
    }

    @Override
    public int compareTo(Mileage other) {
        if (other == null) {
            throw new IllegalArgumentException("null은 비교할 수 없습니다.");
        }
        return distance - other.distance;
    }

}
