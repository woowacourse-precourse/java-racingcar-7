package racingcar.dto;

import java.util.List;
import racingcar.domain.car.Car;

public class RaceResultDTO {

    private final List<Car> raceWinners;

    public RaceResultDTO(List<Car> raceWinners) {
        this.raceWinners = raceWinners;
    }

    public String convertWinnersToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : raceWinners) {
            stringBuilder.append(" ");
            stringBuilder.append(car.getMember().getName());
            stringBuilder.append(",");
        }
        if (!stringBuilder.isEmpty()) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

}
