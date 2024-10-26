package racingcar.racingapp.model.value.vo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.racingapp.model.value.enums.RaceMaxCounts;

public record CarNames(List<CarName> carNames) {

    private static final Integer LIMIT_OF_PARTICIPANTS = RaceMaxCounts.MAX_COUNT_OF_CAR.getCount();

    public CarNames {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("참가자 이름들이 지정되지 않았습니다.");
        }
        if (carNames.stream()
                .collect(Collectors.groupingBy(CarName::name, Collectors.counting()))
                .values().stream()
                .anyMatch(countOfSameName -> 1 < countOfSameName)) {
            throw new IllegalArgumentException("참가자 이름은 중복될 수 없습니다.");
        }
        if (LIMIT_OF_PARTICIPANTS < carNames.size()) {
            throw new IllegalArgumentException(String.format("지정 가능한 최대 참가자 수는 %d입니다.", LIMIT_OF_PARTICIPANTS));
        }

        carNames = List.copyOf(carNames);
    }

    public Stream<CarName> stream() {
        return carNames.stream();
    }

}
