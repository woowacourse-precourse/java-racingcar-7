package racingcar.global.dto;

import java.util.List;

public record CarRaceRequestDTO(List<String> carNames, Integer gamePlayCount) {
}
