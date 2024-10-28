package racingcar.domain.race.dto;

import java.util.List;
import racingcar.domain.car.dto.CarsResultDto;

public record RaceResultDto(List<CarsResultDto> carsResultDtos) {
}
