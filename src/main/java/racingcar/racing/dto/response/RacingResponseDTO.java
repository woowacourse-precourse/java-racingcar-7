package racingcar.racing.dto.response;

import java.util.List;
import racingcar.racing.domain.Car;

public record RacingResponseDTO(List<CarResult> carResults, Integer round) {

    public static RacingResponseDTO from(List<Car> cars, Integer round) {
        return new RacingResponseDTO(cars.stream().map(CarResult::from).toList(), round);
    }
}
