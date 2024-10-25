package racingcar.object.value;

import java.util.List;
import racingcar.object.enums.RaceMaxCounts;

public record CarNames(List<CarName> carNames) {

    private static final Integer LIMIT_OF_PARTICIPANTS = RaceMaxCounts.MAX_COUNT_OF_CAR.getCount();

    public CarNames {
        if (carNames == null) {
            throw new IllegalArgumentException("참가자 이름들이 지정되지 않았습니다.");
        }
        if (LIMIT_OF_PARTICIPANTS < carNames.size()) {
            throw new IllegalArgumentException(String.format("지정 가능한 최대 참가자 수는 %d입니다.", LIMIT_OF_PARTICIPANTS));
        }

        carNames = List.copyOf(carNames);
    }

}
