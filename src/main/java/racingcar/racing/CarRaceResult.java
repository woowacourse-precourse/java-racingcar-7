package racingcar.racing;

import java.util.List;

public record CarRaceResult(
        List<CarRacer> winners,
        List<String> histories
) {

    public static CarRaceResult of(List<CarRacer> winners, List<String> histories) {
        return new CarRaceResult(winners, histories);
    }
}
