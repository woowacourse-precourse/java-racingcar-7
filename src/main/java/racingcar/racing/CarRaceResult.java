package racingcar.racing;

import java.util.List;
import racingcar.persistence.CarRaceHistory;

public record CarRaceResult(
        List<RacingCar> winners,
        CarRaceHistory carRaceHistory
) {

    public static CarRaceResult of(List<RacingCar> winners, CarRaceHistory carRaceHistory) {
        return new CarRaceResult(winners, carRaceHistory);
    }
}
