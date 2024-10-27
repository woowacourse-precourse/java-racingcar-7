package racingcar.dto;

import java.util.List;
import racingcar.domain.Car;
import racingcar.vo.Name;

public record WinnerNamesDto(List<String> winners) {
    public static WinnerNamesDto from(List<Car> winningCars) {
        List<String> winnerNames = winningCars.stream()
                .map(Car::getName)
                .map(Name::getValue)
                .toList();

        return new WinnerNamesDto(List.copyOf(winnerNames));
    }
}
