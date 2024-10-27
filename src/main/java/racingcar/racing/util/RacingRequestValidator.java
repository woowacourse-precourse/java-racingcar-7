package racingcar.racing.util;

import java.util.HashSet;
import java.util.List;
import racingcar.racing.dto.request.RacingRequestDTO;

public class RacingRequestValidator {

    public static void validateRacingRequest(RacingRequestDTO racingRequestDTO) {
        validateCarNameLength(racingRequestDTO.carNames());
        validateDuplicateCarName(racingRequestDTO.carNames());
        validateRound(racingRequestDTO.round());
    }

    private static void validateCarNameLength(List<String> carNames) {
        carNames.stream()
                .filter(carName -> carName.isBlank() || (5 < carName.length()))
                .findAny()
                .ifPresent(carName -> {
                    throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하여야 합니다.");
                });
    }

    private static void validateDuplicateCarName(List<String> carNames) {
        HashSet<String> carNameSet = new HashSet<>(carNames);
        if (carNameSet.size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

    private static void validateRound(Integer round) {
        if (round <= 0) {
            throw new IllegalArgumentException("레이싱 횟수는 0보다 커야 합니다.");
        }
    }
}
