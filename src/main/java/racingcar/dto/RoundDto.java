package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;

public record RoundDto(List<CarDto> cars) {

    public static RoundDto from(List<Car> cars) {
        List<CarDto> carDtos = cars.stream()
                .map(CarDto::new)
                .toList();
        return new RoundDto(carDtos);
    }
}
