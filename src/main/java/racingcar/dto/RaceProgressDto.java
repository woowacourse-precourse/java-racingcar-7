package racingcar.dto;

import java.util.List;
import racingcar.domain.car.Cars;

public class RaceProgressDto {
    private final List<CarProgressDto> carProgressList;

    private RaceProgressDto(List<CarProgressDto> carProgressList) {
        this.carProgressList = carProgressList;
    }

    public static RaceProgressDto from(final Cars cars) {
        List<CarProgressDto> carProgressList = cars.getCars().stream()
                .map(car -> CarProgressDto.of(car.getName(), car.getPosition()))
                .toList();
        return new RaceProgressDto(carProgressList);
    }

    public List<CarProgressDto> getCarProgressList() {
        return carProgressList;
    }
}