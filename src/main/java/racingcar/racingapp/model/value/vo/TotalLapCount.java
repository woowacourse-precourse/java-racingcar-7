package racingcar.racingapp.model.value.vo;

import racingcar.racingapp.model.value.enums.RaceMaxCounts;

public record TotalLapCount(Integer lapCount) {

    private static final Integer LIMIT_OF_LAP_COUNT = RaceMaxCounts.MAX_COUNT_OF_LAP.getCount();

    public TotalLapCount {
        if (lapCount == null) {
            throw new IllegalArgumentException("랩 수가 입력되지 않았습니다.");
        }
        if (lapCount < 1) {
            throw new IllegalArgumentException("랩 수는 양수여야 합니다.");
        }
        if (LIMIT_OF_LAP_COUNT.compareTo(lapCount) < 0) {
            throw new IllegalArgumentException(String.format("지정 가능한 최대 랩 수는 %d입니다.", LIMIT_OF_LAP_COUNT));
        }
    }

}
