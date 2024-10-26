package racingcar.dto;

import java.util.List;
import racingcar.vo.CarsPositionSnapshot;

public record CarsPositionDto(List<CarPositionDto> carPositions) {
    public static CarsPositionDto from(CarsPositionSnapshot carsPositionSnapshot) {
        List<CarPositionDto> CarPositionDtos = carsPositionSnapshot.getValue().entrySet().stream()
                .map(CarPositionDto::fromEntry).toList();

        return new CarsPositionDto(CarPositionDtos);
    }
}
