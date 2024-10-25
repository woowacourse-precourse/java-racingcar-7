package racingcar.controller.dto;

import java.util.List;
import racingcar.model.Car;

public record RaceResultDTO(
        List<CarResult> cars
) {
    public RaceResultDTO from(List<Car> winners) {
        return new RaceResultDTO(
                winners.stream()
                        .map(CarResult::from)
                        .toList()
        );
    }

    public record CarResult(
            String name,
            int position
    ) {
        private static CarResult from(Car car) {
            return new CarResult(car.getName(), car.getPosition());
        }
    }
}
