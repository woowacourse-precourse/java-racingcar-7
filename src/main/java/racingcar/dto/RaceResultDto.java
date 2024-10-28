package racingcar.dto;

import java.util.List;
import racingcar.domain.car.Car;

public class RaceResultDto {
    private final List<String> winnerNames;

    private RaceResultDto(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public static RaceResultDto from(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .toList();
        return new RaceResultDto(winnerNames);
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}