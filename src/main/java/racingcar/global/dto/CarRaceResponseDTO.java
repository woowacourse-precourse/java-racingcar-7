package racingcar.global.dto;

import java.util.List;

public record CarRaceResponseDTO(List<CarRaceResult> carRaceResults, Integer gamePlayCount) {
}
