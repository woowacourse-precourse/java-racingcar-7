package racingcar.object.value;

import racingcar.object.enums.RaceMaxCounts;

public record TotalLapCount(Integer lapCount) {

    private static final Integer LIMIT_OF_LAP_COUNT = RaceMaxCounts.MAX_COUNT_OF_LAP.getCount();

    public TotalLapCount {
        if (lapCount == null) {
            throw new IllegalArgumentException("랩 수가 입력되지 않았습니다.");
        }
        if (lapCount < 0) {
            throw new IllegalArgumentException("랩 수를 음수로 지정할 수 없습니다.");
        }
        if (LIMIT_OF_LAP_COUNT.compareTo(lapCount) < 0) {
            throw new IllegalArgumentException(String.format("지정 가능한 최대 랩 수는 %d입니다.", LIMIT_OF_LAP_COUNT));
        }
    }

}
